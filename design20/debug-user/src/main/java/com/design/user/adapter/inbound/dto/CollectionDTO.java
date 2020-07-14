package com.design.user.adapter.inbound.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CollectionDTO {
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
    private int project_id;
    private String collection_time;
    private String images;

    public CollectionDTO(int match_id, int project_id, String collection_time, String images) {
        this.match_id = match_id;
        this.project_id = project_id;
        this.collection_time = collection_time;
        this.images = images;
    }
}
