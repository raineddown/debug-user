package com.design.user.domain;

import com.design.user.adapter.inbound.dto.MatchDTO;
import com.design.user.adapter.inbound.dto.PrizeDTO;
import com.design.user.adapter.inbound.dto.ProjectDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class Match {
    private int match_id;
    private String mat_type;
    private String mat_name;
    private String desc;

    private List<ProjectDTO> projectDTOList;
    private List<PrizeDTO> prizeDTOList;

    private String pro_name;
    private String address;
    private String time;
    private String pri_type;
    private String year;
    private String project_id;

}
