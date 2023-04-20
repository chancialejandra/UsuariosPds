package com.co.pds.User.controller;

import com.co.pds.User.dto.request.UsuarioRequest;
import com.co.pds.User.persitence.entity.Usuario;
import com.co.pds.User.service.interfaces.IUsuarioService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

  private final IUsuarioService iUsuarioService;

  @PostMapping("/crear")
  public ResponseEntity crearUsuario(@RequestBody UsuarioRequest usuario) {
    var response = iUsuarioService.crearUsuario(usuario);
    return ResponseEntity.status(response.status).body(response);
  }

  @DeleteMapping("/{numeroIdentificacion}")
  public ResponseEntity eliminarUsuario(@PathVariable String numeroIdentificacion) {
    var response = iUsuarioService.eliminarUsuario(numeroIdentificacion);
    return ResponseEntity.status(response.status).body(response);
  }

  @GetMapping("/listar")
  public List<Usuario> findAll() {
    return iUsuarioService.findAll();
  }

  @PutMapping("/editar/{numeroIdentificacion}")
  public ResponseEntity actualizarUsuario(
      @RequestBody UsuarioRequest usuario, @PathVariable String numeroIdentificacion) {
    var response = iUsuarioService.actualizarUsuario(usuario, numeroIdentificacion);
    return ResponseEntity.status(HttpStatus.OK).body(response);
  }
}
