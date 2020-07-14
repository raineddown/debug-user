package com.design.check.adapter.inbound;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeclareDTO {
    private int begin_id;
    private int match_id;
    private String vote_begin;
    private String vote_end;
    private String declare_begin;
    private String declare_end;
    private int count;
    private Integer state;

    public DeclareDTO(int begin_id, String declare_begin, String declare_end) {
        this.begin_id = begin_id;
        this.declare_begin = declare_begin;
        this.declare_end = declare_end;
    }
}
