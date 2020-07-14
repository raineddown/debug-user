package com.design.user.domain;

import com.design.user.adapter.inbound.dto.CollectionDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Collections {
    private int collection_id;
    private int project_id;
    private int match_id;
    private String collection_time;


}
