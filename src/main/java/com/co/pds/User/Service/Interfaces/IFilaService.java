package com.co.pds.User.service.interfaces;

import com.co.pds.User.dto.request.FilaRequest;
import com.co.pds.User.dto.response.MessageResponse;

public interface IFilaService {

    MessageResponse crearFila(FilaRequest fila);
    MessageResponse eliminarFila(FilaRequest fila);
    MessageResponse buscarFila(int id);
    MessageResponse listarFila();

}
