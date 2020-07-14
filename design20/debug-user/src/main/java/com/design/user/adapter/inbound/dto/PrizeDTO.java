package com.design.user.adapter.inbound.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrizeDTO {
    private int project_id;
    private String pri_type;
    private int match_id;
    private String year;
}
