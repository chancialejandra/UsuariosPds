package com.co.pds.User.dto.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UsuarioRequest {

    @NotBlank(message = "El nombre no  puede estar vacio")
    private String nombre;
    @NotBlank(message = "El numero de idendtificaion no puede estar vacio")
    private String numeroIdentificacion;

    private Date fechaNacimiento;

}



















