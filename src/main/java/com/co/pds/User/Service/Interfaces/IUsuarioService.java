package com.co.pds.User.Service.Interfaces;

import com.co.pds.User.Dto.Request.UsuarioRequest;
import com.co.pds.User.Dto.Response.MessageResponse;
import com.co.pds.User.Persitence.Entity.Usuario;

import java.util.Date;
import java.util.Optional;

public interface IUsuarioService {

    int[] mayorDeEdad(Date fechaNacimiento);
    MessageResponse crearUsuario(UsuarioRequest usuario);
    
    Boolean findByNumeroIdenficacion(String identificacion);

}
