package com.design.user.application.outbound;

import com.design.user.adapter.inbound.dto.CollectionDTO;
import com.design.user.domain.Collections;

import java.util.List;

public interface CollectionRepository {
    List<CollectionDTO> findAllCollection();

    boolean addCollection(int project_id,int match_id,String collection_time,String images);

    List<CollectionDTO> findCollection(int user_id);

    int countUser();

    int countPrize();

    int countExpert();

    int countProject();
}
