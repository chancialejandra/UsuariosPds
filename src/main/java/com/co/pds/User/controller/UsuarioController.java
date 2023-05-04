package com.co.pds.User.controller;

import com.co.pds.User.dto.request.UsuarioEditRequest;
import com.co.pds.User.dto.request.UsuarioRequest;
import com.co.pds.User.persitence.entity.Tarea;
import com.co.pds.User.persitence.entity.Usuario;
import com.co.pds.User.service.interfaces.IUsuarioService;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final IUsuarioService iUsuarioService;

    @PostMapping("/crear")
    public ResponseEntity crearUsuario(@Valid @RequestBody UsuarioRequest usuario){
       var response = iUsuarioService.crearUsuario(usuario);
        return ResponseEntity.status(response.status).body(response);
    }

    @DeleteMapping("/{numeroIdentificacion}")
    public ResponseEntity eliminarUsuario(@Valid @PathVariable String numeroIdentificacion){
        var response = iUsuarioService.eliminarUsuario(numeroIdentificacion);
        return ResponseEntity.status(response.status).body(response);
    }

    @GetMapping("/listar")
    public ResponseEntity listarTareas(){
        List<Usuario> lista = iUsuarioService.listarUsuarios();
        if (lista.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body("No hay usuarios registrados");
        }

        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

    @PutMapping("/editar/{numeroIdentificacion}")
    public ResponseEntity actualizarUsuario(
            @Valid @RequestBody UsuarioEditRequest usuario, @PathVariable String numeroIdentificacion) {
        var response = iUsuarioService.actualizarUsuario(usuario, numeroIdentificacion);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }



}
