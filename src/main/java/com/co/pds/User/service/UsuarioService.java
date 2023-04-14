package com.co.pds.User.service;

import com.co.pds.User.Persitence.entity.Usuario;
import com.co.pds.User.Persitence.repository.IUsuarioRepository;
import com.co.pds.User.service.interfaces.IUsuarioService;
import com.co.pds.User.dto.request.UsuarioRequest;
import com.co.pds.User.dto.response.MessageResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class UsuarioService implements IUsuarioService {
    private final IUsuarioRepository iUsuarioRepository;
    ModelMapper mapper = new ModelMapper();

    //Metodo para saber si el usuario es mayor de edad
    @Override
    public int[] mayorDeEdad(Date fechaNacimiento) {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        String date = format.format(System.currentTimeMillis());
        String dateUser = format.format(fechaNacimiento);

        // --- fecha de sistema --//
        String[] sys = date.split("-");
        Integer fechaSyst = Integer.parseInt(sys[0]);
        Integer mesSyst = Integer.parseInt(sys[1]);
        Integer anoSyst = Integer.parseInt(sys[2]);

        //-- fecha nacimiento usuario--//
        String[] dateBirtth = dateUser.split("-");
        Integer dateBirtthUser = Integer.parseInt(dateBirtth[0]);
        Integer monthUser = Integer.parseInt(dateBirtth[1]);
        Integer anoUser = Integer.parseInt(dateBirtth[2]);

        int b = 0;
        int dias = 0;
        int month = 0;
        int anios = 0;
        int monthes = 0;
        month = mesSyst - 1;


        if (month == 2) {
            if ((anoUser % 4 == 0) && ((anoUser % 100 != 0) || (anoUser % 400 == 0))) {
                b = 29;
            } else {
                b = 28;
            }
        } else if (month <= 7) {
            if (month == 0) {
                b = 31;
            } else if (month % 2 == 0) {
                b = 30;
            } else {
                b = 31;
            }
        } else if (month > 7) {
            if (month % 2 == 0) {
                b = 31;
            } else {
                b = 30;
            }
        }
        if ((anoSyst > anoUser) || (anoSyst == anoUser && mesSyst > monthUser)
                || (anoSyst == anoUser && mesSyst ==monthUser && fechaSyst > dateBirtthUser)) {
            System.out.println("La fecha de inicio debe ser anterior a la fecha Actual");
        } else {
            if (mesSyst <= monthUser) {
                anios = anoUser - anoSyst;
                if (fechaSyst <= dateBirtthUser) {
                    monthes = monthUser - mesSyst;
                    dias = b - (fechaSyst - dateBirtthUser);
                } else {
                    if (monthUser == mesSyst) {
                        anios = anios - 1;
                    }
                    monthes = (monthUser - mesSyst - 1 + 12) % 12;
                    dias = b - (fechaSyst - dateBirtthUser);
                }
            } else {
                anios = anoUser - anoSyst - 1;
                System.out.println(anios);
                if (fechaSyst > dateBirtthUser) {
                    monthes = monthUser - mesSyst - 1 + 12;
                    dias = b - (fechaSyst - dateBirtthUser);
                } else {
                    monthes = monthUser - mesSyst + 12;
                    dias = dateBirtthUser - fechaSyst;
                }
            }
        }
        int[] ege = new int[3];
        ege[0]=dias;
        ege[1]=monthes;
        ege[2]=anios;

        return ege;
    }

    @Override
    public MessageResponse crearUsuario(UsuarioRequest usuarioRequest) {
        Usuario usuario = mapper.map(usuarioRequest, Usuario.class);
        MessageResponse responseMessage = MessageResponse.builder().build();

        try {
            if(!findByNumeroIdenficacion(usuario.getNumeroIdentificacion())){
                int[] egeUser = (mayorDeEdad(usuario.getFechaNacimiento()));
                if(egeUser[0] == 29 && egeUser[1] == 11 && egeUser[2] == -1) {
                    return MessageResponse.builder()
                            .message("La fecha de nacimiento debe ser anterior a la fecha actual")
                            .status(HttpStatus.BAD_REQUEST)
                            .build();

                }else if( egeUser[2]<18 ){
                    return MessageResponse.builder()
                            .message("El usuario es menor de 18 años no puede registrarse")
                            .status(HttpStatus.BAD_REQUEST)
                            .build();
                }else {
                    return MessageResponse.builder()
                            .message("El usuario ya existe")
                            .status(HttpStatus.BAD_REQUEST)
                            .build();
                }
            }else {
                iUsuarioRepository.save(usuario);
                responseMessage = MessageResponse.builder()
                        .message("Registro exitoso")
                        .status(HttpStatus.OK)
                        .build();
                return responseMessage;
            }
        }catch(Exception ex){
            System.out.println("Error creando el usuario");
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
}
