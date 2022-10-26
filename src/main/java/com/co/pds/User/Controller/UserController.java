package com.co.pds.User.Controller;


import com.co.pds.User.Dto.Request.PruebaRequest;
import com.co.pds.User.Dto.Request.UserRequest;
import com.co.pds.User.Service.Interfaces.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    @PostMapping("/prueba")
    public ResponseEntity prueba(@RequestBody PruebaRequest pruebaRequest){
        return ResponseEntity.status(200).body(pruebaRequest);
    }



}
