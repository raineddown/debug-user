package com.design.user.utils;

import com.design.user.adapter.inbound.dto.UserDTO;
import com.design.user.application.inbound.UserUseCase;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class InterceptUtils {
    @Autowired
    private final UserUseCase userUseCase;

    public boolean intercept(String id){
        int user_id = Integer.valueOf(id);
        UserDTO userDTO = userUseCase.findUserOnlyId(user_id);
        if(userDTO.getQualification() == 0){
            return false;
        }else return userDTO.getQualification() == 1;
    }
}
