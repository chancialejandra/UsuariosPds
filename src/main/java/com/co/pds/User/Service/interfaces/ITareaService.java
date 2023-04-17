package com.co.pds.User.service.interfaces;

import com.co.pds.User.dto.response.TareaResponse;
import com.co.pds.User.persitence.entity.Tarea;
import com.co.pds.User.dto.request.TareaRequest;
import com.co.pds.User.dto.response.MessageResponse;


import java.util.List;
import java.util.Optional;

public interface ITareaService {

    MessageResponse crearTarea(TareaRequest tareaRequest);
    MessageResponse eliminarTarea(Long id);

    MessageResponse editarTarea(TareaRequest tareaRequest, Long id);
    boolean nombreTareaExiste(String nombreTarea);
}
