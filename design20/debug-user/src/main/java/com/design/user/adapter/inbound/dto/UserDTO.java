package com.design.user.adapter.inbound.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
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

    /*
    public UserDTO(int user_id, String workplace, String company, String password){
        this.user_id = user_id;
        this.workplace = workplace;
        this.company = company;
        this.password = password;
    }*/

    public UserDTO(String username, String password, String phone, String registerTime) {
        this.username = username;
        this.password = password;
        this.qualification = 0;
        this.phone = phone;
        this.registerTime = registerTime;
    }

    public UserDTO(int user_id, String username, String workplace, String password, Integer qualification, String phone, String company) {
        this.user_id = user_id;
        this.username = username;
        this.workplace = workplace;
        this.password = password;
        this.qualification = qualification;
        this.phone = phone;
        this.company = company;
        if(qualification == 0){
            this.status = "游客账号";
        }else if(qualification == 1){
            this.status = "企业认证账号";
        }else {
            this.status = "错误账号";
        }
    }

    //翻译状态码//
    public String findStatus(int qualification){
        if(qualification == 0){
            return  "游客账号";
        }else if(qualification == 1){
            return  "企业认证账号";
        }else {
            return  "错误账号";
        }
    }
}
