package com.co.pds.User.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Date;
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioEditRequest {
    @NotBlank(message = "El nombre del usuario no  puede estar vacio")
    private String nombre;
    @NotBlank(message = "El numero de idendtificaion no puede estar vacio")
    private String numeroIdentificacion;

    private Date fechaNacimiento;

    private Boolean condicion;

}
