package com.co.pds.Taller_1_Usuarios_Profundizacion.Service;

import com.co.pds.Taller_1_Usuarios_Profundizacion.Dto.Request.UserRequest;
import com.co.pds.Taller_1_Usuarios_Profundizacion.Dto.Response.MessageResponse;
import com.co.pds.Taller_1_Usuarios_Profundizacion.Persitence.Entity.User;
import com.co.pds.Taller_1_Usuarios_Profundizacion.Persitence.Repository.IUserRepository;
import com.co.pds.Taller_1_Usuarios_Profundizacion.Service.Interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Service
public class UserService implements IUserService {

    @Autowired
    IUserRepository iUserRepository;   ModelMapper mapper = new ModelMapper();

    @Override
    public String ege(Date userDateBirth){

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String date = format.format(System.currentTimeMillis());
        String dateUser = format.format(userDateBirth);

        String[] sys = date.split("-");
        Integer dateSyst = Integer.parseInt(sys[0]);
        Integer mesSyst = Integer.parseInt(sys[1]);
        Integer anoSyst = Integer.parseInt(sys[2]);

        String[] dateBirtth = dateUser.split("-");
        Integer dateBirtthUser = Integer.parseInt(dateBirtth[0]);
        Integer mesUser = Integer.parseInt(dateBirtth[1]);
        Integer anoUser = Integer.parseInt(dateBirtth[2]);

        int b = 0;
        int dias = 0;
        int mes = 0;
        int anios = 0;
        int meses = 0;
        mes = mesSyst - 1;
        if (mes == 2) {
            if ((anoUser % 4 == 0) && ((anoUser % 100 != 0) || (anoUser % 400 == 0))) {
                b = 29;
            } else {
                b = 28;
            }
        } else if (mes <= 7) {
            if (mes == 0) {
                b = 31;
            } else if (mes % 2 == 0) {
                b = 30;
            } else {
                b = 31;
            }
        } else if (mes > 7) {
            if (mes % 2 == 0) {
                b = 31;
            } else {
                b = 30;
            }
        }
        if ((anoSyst > anoUser) || (anoSyst == anoUser && mesSyst > mesUser)
                || (anoSyst == anoUser && mesSyst == mesUser && dateSyst > dateBirtthUser)) {
            System.out.println("La fecha de inicio debe ser anterior a la fecha Actual");
        } else {
            if (mesSyst <= mesUser) {
                anios = anoUser - anoSyst;
                if (dateSyst <= dateBirtthUser) {
                    meses = mesUser - mesSyst;
                    dias = b - (dateSyst - dateBirtthUser);
                } else {
                    if (mesUser == mesSyst) {
                        anios = anios - 1;
                    }
                    meses = (mesUser - mesSyst - 1 + 12) % 12;
                    dias = b - (dateSyst - dateBirtthUser);
                }
            } else {
                anios = anoUser - anoSyst - 1;
                System.out.println(anios);
                if (dateSyst > dateBirtthUser) {
                    meses = mesUser - mesSyst - 1 + 12;
                    dias = b - (dateSyst - dateBirtthUser);
                } else {
                    meses = mesUser - mesSyst + 12;
                    dias = dateBirtthUser - dateSyst;
                }
            }
        }
return "Años: " + anios;

    }

    @Override
    public Boolean existingUser(Integer idUser) {
        return iUserRepository.existsById(idUser);
    }
    @Override
    public MessageResponse newUser(UserRequest userRequest) {

        User user = mapper.map(userRequest,User.class);
        MessageResponse responseMessage = null;

        try {
            if(!existingUser(user.getIdUser())){
                int egeUser = Integer.parseInt(ege(user.getDateBirth()));
                if(egeUser < 18) {
                    return MessageResponse.builder()
                            .message("The user is under 18 years old cannot register")
                            .status(HttpStatus.BAD_REQUEST)
                            .build();
                }
                return MessageResponse.builder()
                        .message("User already exists")
                        .status(HttpStatus.BAD_REQUEST)
                        .build();
            }else {
                iUserRepository.save(user);
                responseMessage = MessageResponse.builder()
                        .message("Registro con exito")
                        .status(HttpStatus.OK)
                        .build();
                return responseMessage;
            }
        }catch(Exception ex){
            System.out.println("Error guardando");
        }
        return responseMessage;
    }
}


