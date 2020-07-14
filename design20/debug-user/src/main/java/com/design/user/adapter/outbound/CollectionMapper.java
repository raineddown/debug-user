package com.design.user.adapter.outbound;

import com.design.user.adapter.inbound.dto.CollectionDTO;
import com.design.user.application.outbound.CollectionRepository;
import com.design.user.domain.Collections;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;



import java.util.List;

@Mapper
@Repository
public interface CollectionMapper extends CollectionRepository {
    @Override
    List<CollectionDTO> findAllCollection();

    @Override
    boolean addCollection(int project_id,int match_id,String collection_time,String images);

    @Override
    List<CollectionDTO> findCollection(int user_id);

    @Override
    int countUser();

    @Override
    int countPrize();

    @Override
    int countExpert();

    @Override
    int countProject();
}
