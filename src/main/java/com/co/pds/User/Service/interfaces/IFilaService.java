package com.co.pds.User.service.interfaces;

import com.co.pds.User.dto.request.FilaRequest;
import com.co.pds.User.dto.response.MessageResponse;
import com.co.pds.User.persitence.entity.Fila;

import java.util.List;

public interface IFilaService {

    MessageResponse crearFila(FilaRequest filaRequest);
    MessageResponse eliminarFila(Long idFila);
    Fila buscarFila(Long idFila);
    List<Fila> listarFila();
    MessageResponse editarFila(FilaRequest filaRequest, Long idFila);

}
