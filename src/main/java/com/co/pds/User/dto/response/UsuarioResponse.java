package com.co.pds.User.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
@Data
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UsuarioResponse {
    private String message;
    private String nombre;

    private String numeroIdentificacion;

    private Date fechaNacimiento;

    private boolean condicion;
}
