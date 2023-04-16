package com.co.pds.User.service.interfaces;

import com.co.pds.User.dto.request.UsuarioRequest;
import com.co.pds.User.dto.response.MessageResponse;

import java.util.Date;

public interface IUsuarioService {

    int[] mayorDeEdad(Date fechaNacimiento);
    MessageResponse crearUsuario(UsuarioRequest usuario);
    
    Boolean findByNumeroIdenficacion(String numeroIdentificacion);

    MessageResponse eliminarUsuario(String numeroIdentificacion);
}
