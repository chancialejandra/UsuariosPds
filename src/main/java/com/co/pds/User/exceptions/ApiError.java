package com.co.pds.User.exceptions;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ApiError {
    private String error;

    private String message;

    private Integer status;
}
