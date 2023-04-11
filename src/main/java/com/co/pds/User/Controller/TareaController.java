package com.co.pds.User.Controller;

import com.co.pds.User.Dto.Request.TareaRequest;
import com.co.pds.User.Service.Interfaces.ITareaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


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


}


