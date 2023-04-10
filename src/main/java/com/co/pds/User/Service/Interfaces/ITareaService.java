package com.co.pds.User.Service.Interfaces;

import com.co.pds.User.Dto.Request.TareaRequest;
import com.co.pds.User.Dto.Response.MessageResponse;

public interface ITareaService {

    MessageResponse crearTarea(TareaRequest tarea);
    MessageResponse eliminarTarea(TareaRequest tarea);
    MessageResponse buscarTarea(int id);
    MessageResponse listarTarea();


}
