package com.co.pds.User.Controller;


import com.co.pds.User.Dto.Request.PruebaRequest;
import com.co.pds.User.Dto.Request.UsuarioRequest;
import com.co.pds.User.Dto.Response.MessageResponse;
import com.co.pds.User.Service.Interfaces.IUsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Validated
@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UserController {

    private final IUsuarioService iUsuarioService;

    @PostMapping()
    public ResponseEntity crearUsuario(@Valid @RequestBody UsuarioRequest usuario){
        var response = iUsuarioService.crearUsuario(usuario);
//         return  iUsuarioService.usuarioExistente(usuario.getNumeroIdentificacion());
        return ResponseEntity.status(response.status).body(response);
    }





}
