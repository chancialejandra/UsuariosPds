package com.co.pds.User.dto.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.Date;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UsuarioRequest {
    @NotEmpty(message = "El campo nombre no puede estar vacio")
    private String nombre;
    @NotEmpty(message = "El campo nombre no puede estar vacio")
    private String numeroIdentificacion;
    @NotEmpty(message = "El campo nombre no puede estar vacio")
    private Date fechaNacimiento;

}



















