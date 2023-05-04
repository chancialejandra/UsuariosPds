package com.co.pds.User.service;

import com.co.pds.User.dto.request.FilaRequest;
import com.co.pds.User.dto.response.MessageResponse;
import com.co.pds.User.persitence.entity.Tarea;
import com.co.pds.User.persitence.entity.Usuario;
import com.co.pds.User.persitence.repository.IFilaRepository;
import com.co.pds.User.persitence.entity.Fila;
import com.co.pds.User.persitence.repository.IUsuarioRepository;
import com.co.pds.User.service.interfaces.IFilaService;
import com.co.pds.User.service.interfaces.ITareaService;
import com.co.pds.User.service.interfaces.IUsuarioService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FilaService implements IFilaService {


    private final IFilaRepository iFilaRepository;

    private final ITareaService iTareaService;
    ModelMapper mapper = new ModelMapper();

    @Override
    public MessageResponse crearFila(FilaRequest filaRequest) {
        Fila fila = mapper.map(filaRequest, Fila.class);

        iFilaRepository.save(fila);

        return MessageResponse.builder()
                .message("Fila registrada con exito")
                .status(HttpStatus.BAD_REQUEST)
                .build();
    }

    @Override
    public MessageResponse eliminarFila(Long idFila) {
        MessageResponse responseMessage = MessageResponse.builder().build();

            //Eliminar filas asociadas

            iFilaRepository.deleteById(idFila);
            responseMessage = MessageResponse.builder()
                    .message("Fila elimidada")
                    .status(HttpStatus.OK)
                    .build();
            return responseMessage;
    }

    @Override
    public Fila buscarFila(Long idFila) {
        Optional<Fila> optFila = iFilaRepository.findById(idFila);
        return optFila.get();
    }

    @Override
    public List<Fila> listarFila() {
        return iFilaRepository.findAll();
    }

    @Override
    public MessageResponse editarFila(FilaRequest filaRequest, Long idFila) {
        MessageResponse responseMessage = MessageResponse.builder().build();
        Optional<Fila> optionalFila = iFilaRepository.findById(idFila);

        Fila nuevaFila = optionalFila.get();
        nuevaFila.setDuracion(filaRequest.getDuracion());
      //  nuevaFila.setUsuarios(usuarioService.buscarUsuario(filaRequest.getIdUsuario()));
       // nuevaFila.setTarea(tareaService.buscarTarea(filaRequest.getIdTarea()));

        iFilaRepository.save(nuevaFila);

        responseMessage = MessageResponse.builder()
                .message("Fila editada")
                .status(HttpStatus.OK)
                .build();

        return responseMessage;
    }


}
