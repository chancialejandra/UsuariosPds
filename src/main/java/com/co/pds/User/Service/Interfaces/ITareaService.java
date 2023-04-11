package com.co.pds.User.Service.Interfaces;

import com.co.pds.User.Dto.Request.TareaRequest;
import com.co.pds.User.Dto.Response.MessageResponse;
import com.co.pds.User.Persitence.Entity.Tarea;

import java.util.Optional;

public interface ITareaService {

    MessageResponse crearTarea(TareaRequest tareaRequest);
    MessageResponse eliminarTarea(Long id);
    Optional buscarTarea(Long id);
    MessageResponse listarTarea();


}
