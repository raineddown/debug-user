package com.design.user.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    private String workplace;  //公司名//
    private String company;       //公司执照//
    private String symbol;      //未认证符号//
}
