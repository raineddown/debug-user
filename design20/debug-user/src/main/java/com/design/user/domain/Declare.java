package com.design.user.domain;

import com.design.user.adapter.inbound.dto.DeclareDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
public class Declare {
    private int begin_id;
    private int match_id;
    private String vote_begin;
    private String vote_end;
    private String declare_begin;
    private String declare_end;
    private int count;
    private Integer state;

    public DeclareDTO makeDeclareDTO(){
        DeclareDTO declareDTO = new DeclareDTO();
        declareDTO.setBegin_id(begin_id);
        declareDTO.setMatch_id(match_id);
        declareDTO.setVote_begin(vote_begin);
        declareDTO.setVote_end(vote_end);
        declareDTO.setDeclare_begin(declare_begin);
        declareDTO.setDeclare_end(declare_end);
        declareDTO.setCount(count);
        declareDTO.setState(state);
        return declareDTO;
    }
}
