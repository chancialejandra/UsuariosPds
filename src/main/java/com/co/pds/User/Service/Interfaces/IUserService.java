package com.co.pds.User.Service.Interfaces;

import com.co.pds.User.Dto.Request.UserRequest;
import com.co.pds.User.Dto.Response.MessageResponse;

import java.util.Date;

public interface IUserService {

    int[] ege(Date userDateBirth );
    Boolean existingUser(Integer idUser);
    MessageResponse newUser(UserRequest user);

}
