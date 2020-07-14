package com.design.user.utils;

import com.design.user.adapter.inbound.dto.UserDTO;
import com.design.user.application.inbound.UserUseCase;
import com.design.user.domain.Head;
import com.design.user.domain.IdMessage;
import com.design.user.domain.Message;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

@AllArgsConstructor
@Component
public class UserViewUtils {
    @Autowired
    private final UserUseCase userUseCase;

    public void viewUser(String id, Model model){
        int user_id = Integer.parseInt(id);
        UserDTO userDTO = userUseCase.findUserOnlyId(user_id);
        UserDTO status = new UserDTO();
        model.addAttribute("user",userDTO);
        model.addAttribute("status",status);
        IdMessage idMessage = new IdMessage(id);
        System.out.println(idMessage.getValue());
        model.addAttribute("idMessage",idMessage);
        if(userDTO.getCompany() == null || userDTO.getCompany().equals("") || userDTO.getCompany().equals(" ")){
            Message message = new Message("未认证","未认证","!");
            model.addAttribute("message",message);
        }else if (userDTO.getQualification() == 1){
            Message message = new Message(userDTO.getWorkplace(),"已审核","");
            model.addAttribute("message",message);
        } else {
            Message message = new Message(userDTO.getWorkplace(),"已认证(未审核)","");
            model.addAttribute("message",message);
        }
        if(userDTO.getImg() == null || userDTO.getImg().equals("")){
            Head head = new Head("/img/profile-avatar.jpg");
            model.addAttribute("head",head);
        }else {
            Head head = new Head(userDTO.getImg());
            model.addAttribute("head",head);
            System.out.println(head);
        }


    }
}
