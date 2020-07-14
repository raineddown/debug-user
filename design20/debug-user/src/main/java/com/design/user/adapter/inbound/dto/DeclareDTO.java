package com.design.user.adapter.inbound.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeclareDTO {
    private int begin_id;
    private int match_id;
    private String vote_begin;
    private String vote_end;
    private String declare_begin;
    private String declare_end;
    private int count;
    private Integer state;

    private List<MatchDTO> matchDTOList;

    private String mat_type;
    private String mat_name;

    public DeclareDTO(int begin_id, int match_id, String vote_begin, String vote_end, String declare_begin, String declare_end, int count, Integer state) {
        this.begin_id = begin_id;
        this.match_id = match_id;
        this.vote_begin = vote_begin;
        this.vote_end = vote_end;
        this.declare_begin = declare_begin;
        this.declare_end = declare_end;
        this.count = count;
        this.state = state;
    }

    public DeclareDTO(int match_id, String mat_type, String mat_name) {
        this.match_id = match_id;
        this.mat_type = mat_type;
        this.mat_name = mat_name;
    }
}
