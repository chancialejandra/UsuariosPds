package com.co.pds.User.dto.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Range;


@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)

public class FilaRequest {

    @Range(min=1,max=60)
    @NotNull(message = "La duración de la fila no puede estar vacia")
    private int duracion;
    @NotNull(message = "El id de la tarea no puede estar vacio")
    private Long idTarea;
    @NotNull(message = "El id del usuario no puede estar vacio")
    private Long idUsuario;


}
