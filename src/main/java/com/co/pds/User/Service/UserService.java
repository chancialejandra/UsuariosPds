package com.co.pds.User.Service;

import com.co.pds.User.Dto.Request.UserRequest;
import com.co.pds.User.Dto.Response.MessageResponse;
import com.co.pds.User.Persitence.Entity.User;
import com.co.pds.User.Persitence.Repository.IUserRepository;
import com.co.pds.User.Service.Interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class UserService implements IUserService {

    @Autowired
    IUserRepository iUserRepository;
    ModelMapper mapper = new ModelMapper();

    @Override
    public int[] ege(Date userDateBirth){

        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        String date = format.format(System.currentTimeMillis());
        String dateUser = format.format(userDateBirth);

        // --- fecha de sistema --//
        String[] sys = date.split("-");
        Integer dateSyst = Integer.parseInt(sys[0]);
        Integer monthSyst = Integer.parseInt(sys[1]);
        Integer anoSyst = Integer.parseInt(sys[2]);

        //-- fecha nacimiento usuario--//
        String[] dateBirtth = dateUser.split("-");
        Integer dateBirtthUser = Integer.parseInt(dateBirtth[0]);
        Integer monthUser = Integer.parseInt(dateBirtth[1]);
        Integer anoUser = Integer.parseInt(dateBirtth[2]);

        int b = 0;
        int dias = 0;
        int month = 0;
        int anios = 0;
        int monthes = 0;
        month = monthSyst - 1;


        if (month == 2) {
            if ((anoUser % 4 == 0) && ((anoUser % 100 != 0) || (anoUser % 400 == 0))) {
                b = 29;
            } else {
                b = 28;
            }
        } else if (month <= 7) {
            if (month == 0) {
                b = 31;
            } else if (month % 2 == 0) {
                b = 30;
            } else {
                b = 31;
            }
        } else if (month > 7) {
            if (month % 2 == 0) {
                b = 31;
            } else {
                b = 30;
            }
        }
        if ((anoSyst > anoUser) || (anoSyst == anoUser && monthSyst > monthUser)
                || (anoSyst == anoUser && monthSyst ==monthUser && dateSyst > dateBirtthUser)) {
            System.out.println("La fecha de inicio debe ser anterior a la fecha Actual");
        } else {
            if (monthSyst <= monthUser) {
                anios = anoUser - anoSyst;
                if (dateSyst <= dateBirtthUser) {
                    monthes = monthUser - monthSyst;
                    dias = b - (dateSyst - dateBirtthUser);
                } else {
                    if (monthUser == monthSyst) {
                        anios = anios - 1;
                    }
                    monthes = (monthUser - monthSyst - 1 + 12) % 12;
                    dias = b - (dateSyst - dateBirtthUser);
                }
            } else {
                anios = anoUser - anoSyst - 1;
                System.out.println(anios);
                if (dateSyst > dateBirtthUser) {
                    monthes = monthUser - monthSyst - 1 + 12;
                    dias = b - (dateSyst - dateBirtthUser);
                } else {
                    monthes = monthUser - monthSyst + 12;
                    dias = dateBirtthUser - dateSyst;
                }
            }
        }
        int[] ege = new int[3];
        ege[0]=dias;
        ege[1]=monthes;
        ege[2]=anios;

        return ege;
    }

    @Override
    public Boolean existingUser(Integer idUser) {
        boolean prueba = iUserRepository.existsById(idUser);
        return prueba;
    }
    @Override
    public MessageResponse newUser(UserRequest userRequest) {

        User user = mapper.map(userRequest,User.class);
        MessageResponse responseMessage = null;

        try {
            if( true){
                int[] egeUser = (ege(user.getDateBirth()));
                if(egeUser[0] == 29 && egeUser[1] == 11 && egeUser[2] == -1) {
                    return MessageResponse.builder()
                            .message("The date of birth must be before the Current date")
                            .status(HttpStatus.BAD_REQUEST)
                            .build();

                }else if( egeUser[2]<18 ){
                    return MessageResponse.builder()
                            .message("The user is under 18 years old cannot register")
                            .status(HttpStatus.BAD_REQUEST)
                            .build();
                }else {
                    return MessageResponse.builder()
                            .message("User already exists")
                            .status(HttpStatus.BAD_REQUEST)
                            .build();
                }
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


