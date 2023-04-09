package com.co.pds.User.Service.Interfaces;

import com.co.pds.User.Dto.Request.UsuarioRequest;
import com.co.pds.User.Dto.Response.MessageResponse;

import java.util.Date;

public interface IUsuarioService {

    int[] mayorDeEdad(Date fechaNacimiento);
    MessageResponse crearUsuario(UsuarioRequest usuario);

}
