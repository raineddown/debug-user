package com.design.user.domain;

import com.design.user.adapter.inbound.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int user_id;
    private String username;
    private String workplace;
    private String password;
    private Integer qualification;
    private String phone;
    private String company;
    private String img;
    private String registerTime;

    private String status;

    public User(String username, String password, String phone, String registerTime) {
        this.username = username;
        this.password = password;
        this.qualification = 0;
        this.phone = phone;
        this.registerTime = registerTime;
    }

    public UserDTO makeUserDTO(){
        UserDTO userDTO = new UserDTO();
        userDTO.setUser_id(user_id);
        userDTO.setWorkplace(workplace);
        userDTO.setUsername(username);
        userDTO.setPassword(password);
        userDTO.setQualification(qualification);
        userDTO.setPhone(phone);
        userDTO.setCompany(company);
        userDTO.setImg(img);
        userDTO.setRegisterTime(registerTime);
        return userDTO;
    }
}
