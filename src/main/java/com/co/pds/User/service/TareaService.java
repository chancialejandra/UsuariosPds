package com.co.pds.User.service;


import com.co.pds.User.persitence.repository.ITareaRepository;

import com.co.pds.User.persitence.entity.Tarea;
import com.co.pds.User.service.interfaces.ITareaService;
import com.co.pds.User.dto.request.TareaRequest;
import com.co.pds.User.dto.response.MessageResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TareaService implements ITareaService {

        @Autowired
        ITareaRepository iTareaRepository;
        ModelMapper mapper = new ModelMapper();

        @Override
        public MessageResponse crearTarea(TareaRequest tareaRequest) {

                Tarea tarea = mapper.map(tareaRequest, Tarea.class);
                MessageResponse responseMessage = MessageResponse.builder().build();

                if (nombreTareaExiste(tarea.getNombreTarea())) {
                        iTareaRepository.save(tarea);
                        responseMessage = MessageResponse.builder()
                                .message("Tarea guardada")
                                .status(HttpStatus.OK)
                                .build();
                } else {
                        responseMessage = MessageResponse.builder()
                                .message("No se puede guardar la tarea, ya existe" +
                                        " una tarea con el nombre " + tarea.getNombreTarea())
                                .status(HttpStatus.OK)
                                .build();
                }
                return responseMessage;


        }

        @Override
        public MessageResponse eliminarTarea(Long id) {

                MessageResponse responseMessage = MessageResponse.builder().build();
                Optional<Tarea> optionalTarea = iTareaRepository.findById(id);

                if (optionalTarea.isPresent()) {
                        iTareaRepository.deleteById(id);
                        responseMessage = MessageResponse.builder()
                                .message("Tarea elimidada")
                                .status(HttpStatus.OK)
                                .build();
                } else {
                        responseMessage = MessageResponse.builder()
                                .message("No se puede eliminar, no existe tarea con un ID: " + id)
                                .status(HttpStatus.BAD_REQUEST)
                                .build();
                }
                return responseMessage;


        }

        @Override
        public Tarea buscarTarea(Long id) {
                Optional<Tarea> optTarea = iTareaRepository.findById(id);
                if (optTarea.isPresent()) {
                        return optTarea.get();
                } else {
                        return null;
                }
        }

        @Override
        public List<Tarea> listarTarea() {
                return iTareaRepository.findAll();
        }

        @Override
        public MessageResponse editarTarea(TareaRequest tareaRequest, Long id) {

                MessageResponse responseMessage = MessageResponse.builder().build();
                Optional<Tarea> optionalTarea = iTareaRepository.findById(id);

                if (optionalTarea.isPresent()) { //La tarea existe
                        Tarea nuevaTarea = optionalTarea.get();
                        nuevaTarea.setNombreTarea(tareaRequest.getNombre());
                        iTareaRepository.save(nuevaTarea);

                        responseMessage = MessageResponse.builder()
                                .message("Tarea editada")
                                .status(HttpStatus.OK)
                                .build();

                } else {
                        responseMessage = MessageResponse.builder()
                                .message("No se puede editar, no existe tarea con un ID: " + id)
                                .status(HttpStatus.BAD_REQUEST)
                                .build();
                }
                return responseMessage;

        }

        @Override
        public boolean nombreTareaExiste(String nombre) {
                //if (iTareaRepository.findByNombre(nombre).isPresent()) {
                        return true;
                //} else {
                //        return false;
                //}
        }
}

