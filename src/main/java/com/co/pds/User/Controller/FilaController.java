package com.co.pds.User.Controller;

import com.co.pds.User.Dto.Request.FilaRequest;
import com.co.pds.User.Service.Interfaces.IFilaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Validated
@RestController
@RequestMapping("/fila")
@RequiredArgsConstructor
public class FilaController {

    private final IFilaService iFilaService;

    @PostMapping()
    public ResponseEntity crearFila(@Valid @RequestBody FilaRequest fila){
    return  null;
    }


}


