package com.co.pds.User.service.interfaces;

import com.co.pds.User.dto.request.UsuarioEditRequest;
import com.co.pds.User.dto.request.UsuarioRequest;
import com.co.pds.User.dto.response.MessageResponse;
import com.co.pds.User.dto.response.UsuarioResponse;
import com.co.pds.User.persitence.entity.Usuario;

import java.util.Date;
import java.util.List;

public interface IUsuarioService {

    int[] mayorDeEdad(Date fechaNacimiento);
    MessageResponse crearUsuario(UsuarioRequest usuario);
    
    Boolean findByNumeroIdenficacion(String numeroIdentificacion);

    MessageResponse eliminarUsuario(String numeroIdentificacion);

    public List<Usuario> findAll();

    public UsuarioResponse actualizarUsuario(UsuarioEditRequest usuarioRequest, String numeroIdentificacion);

    public Usuario buscarUsuario(Long id);
}
