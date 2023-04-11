package com.co.pds.User.Service;

import com.co.pds.User.Persitence.Repository.Entity.Usuario;
import com.co.pds.User.dto.Request.UsuarioRequest;
import com.co.pds.User.dto.Response.MessageResponse;

import java.util.Date;
import java.util.Optional;

public interface IUsuarioService {

    int[] mayorDeEdad(Date fechaNacimiento);
    MessageResponse crearUsuario(UsuarioRequest usuario);
    
    Boolean findByNumeroIdenficacion(String numeroIdentificacion);

}
