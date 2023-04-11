package com.co.pds.User.controller;

import com.co.pds.User.dto.Request.UsuarioRequest;
import com.co.pds.User.Service.IUsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final IUsuarioService iUsuarioService;

    @PostMapping()
    public ResponseEntity crearUsuario(@Valid @RequestBody UsuarioRequest usuario){
        var response = iUsuarioService.crearUsuario(usuario);
        return ResponseEntity.status(response.status).body(response);
    }

}
