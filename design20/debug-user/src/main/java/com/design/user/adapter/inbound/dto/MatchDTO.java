package com.design.user.adapter.inbound.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatchDTO {
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

    public MatchDTO(int match_id, String mat_type, String mat_name, String desc, List<ProjectDTO> projectDTOList, List<PrizeDTO> prizeDTOList) {
        this.match_id = match_id;
        this.mat_type = mat_type;
        this.mat_name = mat_name;
        this.desc = desc;
        this.projectDTOList = projectDTOList;
        this.prizeDTOList = prizeDTOList;
    }

    public MatchDTO(int match_id, String mat_type, String mat_name, String desc) {
        this.match_id = match_id;
        this.mat_type = mat_type;
        this.mat_name = mat_name;
        this.desc = desc;
    }
}
