package com.co.pds.Taller_1_Usuarios_Profundizacion.Dto.Request;

import com.co.pds.Taller_1_Usuarios_Profundizacion.Persitence.Entity.Dependence;
import com.co.pds.Taller_1_Usuarios_Profundizacion.Persitence.Entity.Profile;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserRequest {

    @NotNull(message = "El id no puede estar vacio")
    private Date dateBirth;

    private Dependence dependence;

    private Profile profile;
}
