package com.co.pds.User.controller;


import com.co.pds.User.persitence.entity.Tarea;
import com.co.pds.User.dto.response.MessageResponse;
import com.co.pds.User.service.interfaces.ITareaService;
import com.co.pds.User.dto.request.TareaRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Validated
@RestController
@RequestMapping("/tarea")
@RequiredArgsConstructor
public class TareaController {

    private final ITareaService iTareaService;

    @PostMapping("/crear")
    public ResponseEntity crearTarea(@Valid @RequestBody TareaRequest tareaRequest){
        var response = iTareaService.crearTarea(tareaRequest);
        return ResponseEntity.status(response.status).body(response);
    }


    @DeleteMapping("/eliminar")
    public ResponseEntity eliminarTarea(@Valid Long id){
        var response = iTareaService.eliminarTarea(id);
        return ResponseEntity.status(response.status).body(response);
    }

    @PutMapping("/editar/{idTarea}")
    public MessageResponse editarTarea(@RequestBody TareaRequest tareaRequest, @PathVariable Long idTarea){
        return iTareaService.editarTarea(tareaRequest, idTarea);
    }
    @GetMapping("/listar")
    public ResponseEntity listarTarea() {

        List<Tarea> lista = iTareaService.listarTarea();
        if (lista.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body("No hay datos");
        }
        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

    @GetMapping("/buscar/{idTarea}")
    public Tarea buscarTarea(@PathVariable Long idTarea){
        return iTareaService.buscarTarea(idTarea);
    }
    }





