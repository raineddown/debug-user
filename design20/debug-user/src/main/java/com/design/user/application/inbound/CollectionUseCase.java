package com.design.user.application.inbound;

import com.design.user.adapter.inbound.dto.CollectionDTO;
import com.design.user.domain.Collections;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public interface CollectionUseCase {
    List<CollectionDTO> findAllCollection();

    boolean addCollection(int project_id,int match_id,String collection_time,String images);

    List<CollectionDTO> findCollection(int user_id);

    int countUser();

    int countPrize();

    int countExpert();

    int countProject();
}
