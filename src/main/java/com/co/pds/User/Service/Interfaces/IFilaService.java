package com.co.pds.User.Service.Interfaces;

import com.co.pds.User.Dto.Request.FilaRequest;
import com.co.pds.User.Dto.Response.MessageResponse;

public interface IFilaService {

    MessageResponse crearFila(FilaRequest fila);
    MessageResponse eliminarFila(FilaRequest fila);
    MessageResponse buscarFila(int id);
    MessageResponse listarFila();

}
