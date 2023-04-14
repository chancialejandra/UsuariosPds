package com.co.pds.User.controller;

import com.co.pds.User.Persitence.entity.Tarea;
import com.co.pds.User.dto.response.MessageResponse;
import com.co.pds.User.service.interfaces.ITareaService;
import com.co.pds.User.dto.request.TareaRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
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

    @PostMapping()
    public ResponseEntity crearTarea(@Valid @RequestBody TareaRequest tarea){
        var response = iTareaService.crearTarea(tarea);
        return ResponseEntity.status(response.status).body(response);
    }

    @GetMapping
    public List<Tarea> listarTarea() {
        List<Tarea> lista = iTareaService.listarTarea();
        return lista;
    }

    }





