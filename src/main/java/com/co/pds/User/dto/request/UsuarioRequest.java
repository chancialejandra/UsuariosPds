package com.co.pds.User.dto.request;

import com.co.pds.User.persitence.entity.Dependencia;
import com.co.pds.User.persitence.entity.Perfil;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

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
    @NotBlank(message = "El numero de identificación no puede estar vacio")
    private String numeroIdentificacion;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaNacimiento;
    private Dependencia dependencia;
    private Perfil perfil;

}



















