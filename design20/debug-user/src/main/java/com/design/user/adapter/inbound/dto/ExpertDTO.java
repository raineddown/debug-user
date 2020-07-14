package com.design.user.adapter.inbound.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExpertDTO {
    private int expert_id;
    private String username;
    private String phone;
    private String password;
    private Integer state;
}
