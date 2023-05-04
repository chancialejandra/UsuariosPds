package com.co.pds.User.service;

import com.co.pds.User.dto.request.UsuarioEditRequest;
import com.co.pds.User.dto.response.UsuarioResponse;

import com.co.pds.User.persitence.entity.Fila;

import com.co.pds.User.persitence.entity.Usuario;
import com.co.pds.User.persitence.repository.IUsuarioRepository;
import com.co.pds.User.service.interfaces.IUsuarioService;
import com.co.pds.User.dto.request.UsuarioRequest;
import com.co.pds.User.dto.response.MessageResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.bytebuddy.dynamic.DynamicType;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService implements IUsuarioService {
    private final IUsuarioRepository iUsuarioRepository;
    private final FilaService filaService;
    ModelMapper mapper = new ModelMapper();

    //Metodo para saber si el usuario es mayor de edad
    @Override
    public int[] mayorDeEdad(Date fechaNacimiento) {

        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        String date = format.format(System.currentTimeMillis());
        String dateuser = format.format(fechaNacimiento);

        // --- fecha de sistema --//
        String[] sys = date.split("-");
        Integer fechaSyst = Integer.parseInt(sys[0]);
        Integer mesSyst = Integer.parseInt(sys[1]);
        Integer anoSyst = Integer.parseInt(sys[2]);

        // --- fecha de usuario--//
        String[] fechaNacim = dateuser.split("-");
        Integer dateBirtthUser = Integer.parseInt(fechaNacim[0]);
        Integer monthUser = Integer.parseInt(fechaNacim[1]);
        Integer anoUser = Integer.parseInt(fechaNacim[2]);

        int[] aniosUser = new int[3];

        try {
            if ((anoSyst<anoUser) || (anoSyst == anoUser && mesSyst > monthUser)
                    || (anoSyst == anoUser && mesSyst == monthUser && fechaSyst > dateBirtthUser)) {

                aniosUser[0] = 0;
                aniosUser[1] = 0;
                aniosUser[2] = 0;

                return aniosUser;
            } else {
                LocalDate fechaUser = LocalDate.of(anoUser,monthUser,dateBirtthUser);
                LocalDate fechaaSyst = LocalDate.of(anoSyst,mesSyst,fechaSyst);

                Period periodo = Period.between(fechaUser, fechaaSyst);
                aniosUser[0] = periodo.getDays();
                aniosUser[1] = periodo.getMonths();
                aniosUser[2] = periodo.getYears();

                return aniosUser;
            }

        }catch(Exception ex){
            aniosUser[0] = 0;
            aniosUser[1] = 0;
            aniosUser[2] = 0;

            return aniosUser;
            }
        }

    @Override
    public MessageResponse crearUsuario(UsuarioRequest usuarioRequest) {
        Usuario usuario = mapper.map(usuarioRequest, Usuario.class);
        MessageResponse responseMessage = MessageResponse.builder().build();

        try {
            if(!findByNumeroIdenficacion(usuario.getNumeroIdentificacion())){
                int[] aniosUser = (mayorDeEdad(usuario.getFechaNacimiento()));
                if(aniosUser[0] == 0 && aniosUser[1] == 0 && aniosUser[2]==0) {
                    return MessageResponse.builder()
                            .message("La fecha de nacimiento debe ser anterior a la fecha actual")
                            .status(HttpStatus.BAD_REQUEST)
                            .build();
                }else if( aniosUser[2] < 18 ){
                    return MessageResponse.builder()
                            .message("El usuario es menor de 18 años no puede registrarse")
                            .status(HttpStatus.BAD_REQUEST)
                            .build();
                }else{
                    iUsuarioRepository.save(usuario);
                    responseMessage = MessageResponse.builder()
                            .message("Registro exitoso")
                            .status(HttpStatus.OK)
                            .build();
                    return responseMessage;
                }
            }else{
                return MessageResponse.builder()
                        .message("El usuario ya existe")
                        .status(HttpStatus.BAD_REQUEST)
                        .build();
            }
        }catch(Exception ex){
            responseMessage = MessageResponse.builder()
                    .message("Error creando el usuario")
                    .status(HttpStatus.OK)
                    .build();
        }
        return responseMessage;
    }

    @Override
    public Boolean findByNumeroIdenficacion(String numeroIdentificacion) {
        if (iUsuarioRepository.findByNumeroIdentificacion(numeroIdentificacion).isPresent()) {
            return true;
        }
        return false;
    }

    @Override
    public MessageResponse eliminarUsuario(String identificacion) {
        MessageResponse responseMessage = MessageResponse.builder().build();
        Optional<Usuario> optionalUsuario = iUsuarioRepository.findByNumeroIdentificacion(identificacion);

        if (optionalUsuario.isPresent()) {

            //Eliminar filas asociadas
            List<Fila> filas = filaService.listarFila();
            for (Fila fila : filas) {
                if (fila.getUsuarios().getNumeroIdentificacion() == identificacion) {
                    filaService.eliminarFila(fila.getIdFila());
                }
            }
                    iUsuarioRepository.deleteById(optionalUsuario.get().getIdUsuario());
                    responseMessage = MessageResponse.builder()
                            .message("Usuario elimidado")
                            .status(HttpStatus.OK)
                            .build();
                } else {
                    responseMessage = MessageResponse.builder()
                            .message("No se puede eliminar el usuario, no existe usuario con" +
                                    " un Numero de indentifiacación: " + identificacion)
                            .status(HttpStatus.BAD_REQUEST)
                            .build();
                }
                return responseMessage;

    }

    @Override
    public List<Usuario> listarUsuarios() {
        return iUsuarioRepository.findAll();
    }

    @Override
    public UsuarioResponse actualizarUsuario(UsuarioEditRequest usuarioRequest, String numeroIdentificacion) {

            UsuarioResponse responseUsuario = UsuarioResponse.builder().build();

            var userValidation = iUsuarioRepository.findByNumeroIdentificacion(numeroIdentificacion);

            try {
                if (userValidation.isPresent()) {
                    var oldUser = userValidation.get();

                    oldUser.setNombre(usuarioRequest.getNombre());
                    oldUser.setActivo(usuarioRequest.getCondicion());
                    oldUser.setFechaNacimiento(usuarioRequest.getFechaNacimiento());
                    var response = iUsuarioRepository.save(oldUser);
                    return responseUsuario
                            .builder()
                            .message("Usuario actualizado correctamente")
                            .nombre(response.getNombre())
                            .numeroIdentificacion(response.getNumeroIdentificacion())
                            .fechaNacimiento(response.getFechaNacimiento())
                            .condicion(response.isActivo())
                            .build();
                } else {
                    return responseUsuario.builder().message("Usuario no existe").build();
                }
            } catch (Exception ex) {
                responseUsuario.builder().message("Error actualizando el usuario").build();
            }
            return responseUsuario;
    }

    @Override
    public Usuario buscarUsuario(Long id) {
        Optional<Usuario> optionalUsuario = iUsuarioRepository.findById(id);
        return optionalUsuario.get();
    }
}

