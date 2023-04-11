package com.co.pds.User.Service;

import com.co.pds.User.Dto.Request.TareaRequest;
import com.co.pds.User.Dto.Response.MessageResponse;
import com.co.pds.User.Persitence.Repository.ITareaRepository;
import com.co.pds.User.Persitence.Entity.Tarea;
import com.co.pds.User.Service.Interfaces.ITareaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TareaService implements ITareaService {

        @Autowired
        ITareaRepository iTareaRepository;
        ModelMapper mapper = new ModelMapper();

        @Override
        public MessageResponse crearTarea(TareaRequest tareaRequest){
                Tarea tarea = mapper.map(tareaRequest, Tarea.class);
                MessageResponse responseMessage = MessageResponse.builder().build();

                iTareaRepository.save(tarea);
                responseMessage = MessageResponse.builder()
                        .message("Tarea guardada")
                        .status(HttpStatus.OK)
                        .build();

                return responseMessage;

        }

        @Override
        public  MessageResponse eliminarTarea(Long id) {
                MessageResponse responseMessage = MessageResponse.builder().build();
                 iTareaRepository.deleteById(id);
                responseMessage = MessageResponse.builder()
                        .message("Tarea elimidada")
                        .status(HttpStatus.OK)
                        .build();
                return responseMessage;
        }

        @Override
        public Optional<Tarea> buscarTarea(Long id) {
                return iTareaRepository.findById(id);
        }

        @Override
        public MessageResponse listarTarea() {
               return (MessageResponse) iTareaRepository.findAll();
        }


        }
