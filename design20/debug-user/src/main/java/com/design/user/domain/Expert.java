package com.design.user.domain;

import com.design.user.adapter.inbound.dto.ExpertDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Expert {
    private int expert_id;
    private String username;
    private String phone;
    private String password;
    private int state;

    public ExpertDTO makeExpertDTO(){
        ExpertDTO expertDTO = new ExpertDTO();
        expertDTO.setExpert_id(expert_id);
        expertDTO.setUsername(username);
        expertDTO.setPhone(phone);
        expertDTO.setPassword(password);
        expertDTO.setState(state);
        return expertDTO;
    }
}
