package com.co.pds.User.service.interfaces;

import com.co.pds.User.dto.request.UsuarioRequest;
import com.co.pds.User.dto.response.MessageResponse;
import com.co.pds.User.dto.response.UsuarioResponse;
import com.co.pds.User.persitence.entity.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;

public interface IUsuarioService {

    int[] mayorDeEdad(Date fechaNacimiento);
    MessageResponse crearUsuario(UsuarioRequest usuario);
    
    Boolean findByNumeroIdenficacion(String numeroIdentificacion);

    MessageResponse eliminarUsuario(String numeroIdentificacion);


    public List<Usuario> findAll();


    public UsuarioResponse actualizarUsuario(@RequestBody UsuarioRequest usuario);
}
