package com.co.pds.User.dto.request;

import com.co.pds.User.persitence.entity.Dependencia;
import com.co.pds.User.persitence.entity.Perfil;
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

    private Date fechaNacimiento;

    private Boolean condicion;

    private Dependencia dependencia;
    private Perfil perfil;

}
