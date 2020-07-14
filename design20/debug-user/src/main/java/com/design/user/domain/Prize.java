package com.design.user.domain;

import com.design.user.adapter.inbound.dto.PrizeDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Prize {
    private int project_id;
    private String pri_type;
    private int match_id;
    private String year;

    public PrizeDTO makePrizeDTO(){
        PrizeDTO prizeDTO = new PrizeDTO();
        prizeDTO.setProject_id(project_id);
        prizeDTO.setPri_type(pri_type);
        prizeDTO.setMatch_id(match_id);
        prizeDTO.setYear(year);
        return prizeDTO;
    }
}
