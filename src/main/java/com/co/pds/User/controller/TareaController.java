package com.co.pds.User.controller;

import com.co.pds.User.dto.request.TareaRequest;
import com.co.pds.User.dto.response.MessageResponse;
import com.co.pds.User.service.interfaces.ITareaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/tarea")
@RequiredArgsConstructor
public class TareaController {

  private final ITareaService iTareaService;

  @PostMapping("/crear")
  public ResponseEntity crearTarea(@RequestBody TareaRequest tareaRequest) {
    var response = iTareaService.crearTarea(tareaRequest);
    return ResponseEntity.status(response.status).body(response);
  }

  @DeleteMapping("/eliminar")
  public ResponseEntity eliminarTarea(Long id) {
    var response = iTareaService.eliminarTarea(id);
    return ResponseEntity.status(response.status).body(response);
  }

  @PutMapping("/editar/{idTarea}")
  public MessageResponse editarTarea(
      @RequestBody TareaRequest tareaRequest, @PathVariable Long idTarea) {
    return iTareaService.editarTarea(tareaRequest, idTarea);
  }
}
