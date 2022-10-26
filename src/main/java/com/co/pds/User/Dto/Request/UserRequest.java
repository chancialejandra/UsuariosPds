package com.co.pds.User.Dto.Request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.util.Date;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserRequest {

    private Integer idUser;

    private String name;

   // @NotNull(message = "The date of birth cannot be empty")
    private Date dateBirth;

    private boolean condition;
}



















