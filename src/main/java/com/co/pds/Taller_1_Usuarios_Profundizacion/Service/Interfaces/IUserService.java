package com.co.pds.Taller_1_Usuarios_Profundizacion.Service.Interfaces;

import com.co.pds.Taller_1_Usuarios_Profundizacion.Dto.Request.UserRequest;
import com.co.pds.Taller_1_Usuarios_Profundizacion.Dto.Response.MessageResponse;

import java.util.Date;

public interface IUserService {

    String ege(Date userDateBirth );
    Boolean existingUser(Integer idUser);
    MessageResponse newUser(UserRequest user);

}
