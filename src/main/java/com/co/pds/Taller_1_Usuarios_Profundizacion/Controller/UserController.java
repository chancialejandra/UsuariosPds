package com.co.pds.Taller_1_Usuarios_Profundizacion.Controller;

import com.co.pds.Taller_1_Usuarios_Profundizacion.Dto.Request.UserRequest;
import com.co.pds.Taller_1_Usuarios_Profundizacion.Service.Interfaces.IUserService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Validated
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final IUserService iuserService;

    @PostMapping("/new")
    public ResponseEntity newUser(@Valid @RequestBody UserRequest user){
        var response = iuserService.newUser(user);
        return ResponseEntity.status(response.status).body(response);
    }

}
