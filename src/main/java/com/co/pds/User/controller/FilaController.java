package com.co.pds.User.controller;

import com.co.pds.User.dto.request.FilaRequest;
import com.co.pds.User.dto.request.TareaRequest;
import com.co.pds.User.dto.response.MessageResponse;
import com.co.pds.User.persitence.entity.Fila;
import com.co.pds.User.persitence.entity.Tarea;
import com.co.pds.User.service.interfaces.IFilaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/fila")
@RequiredArgsConstructor
public class FilaController {

    private final IFilaService IFilaService;

    @PostMapping("/Crear")
    public ResponseEntity crearFila(@RequestBody FilaRequest filaRequest){
        var response = IFilaService.crearFila(filaRequest);
        return ResponseEntity.status(response.status).body(response);
    }


    @DeleteMapping("/Eliminar")
    public ResponseEntity eliminarFila(Long idFila){
        var response = IFilaService.eliminarFila(idFila);
        return ResponseEntity.status(response.status).body(response);
    }

    @PutMapping("/Editar/{idFila}")
    public MessageResponse editarFila(@RequestBody FilaRequest filaRequest, @PathVariable Long idFila){
        return IFilaService.editarFila(filaRequest, idFila);
    }
    @GetMapping("/Listar")
    public List<Fila> listarFila() {
        List<Fila> filas = IFilaService.listarFila();
        return filas;
    }

    @GetMapping("/Buscar/{idFila}")
    public Fila buscarFila(@PathVariable Long idFila){
        return IFilaService.buscarFila(idFila);
    }

}
