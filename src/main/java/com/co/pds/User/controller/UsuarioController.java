package com.co.pds.User.controller;

import com.co.pds.User.dto.request.UsuarioRequest;
import com.co.pds.User.service.interfaces.IUsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final IUsuarioService iUsuarioService;

    @PostMapping()
    public ResponseEntity crearUsuario(@RequestBody UsuarioRequest usuario){
       var response = iUsuarioService.crearUsuario(usuario);
        return ResponseEntity.status(response.status).body(response);
    }

    @DeleteMapping()
    public ResponseEntity eliminarUsuario(){
        return null;
    }


}
