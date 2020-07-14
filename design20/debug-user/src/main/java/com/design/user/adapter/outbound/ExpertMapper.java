package com.design.user.adapter.outbound;

import com.design.user.adapter.inbound.dto.ExpertDTO;
import com.design.user.application.outbound.ExpertRepository;
import com.design.user.domain.Expert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ExpertMapper extends ExpertRepository {
    @Override
    List<Expert> userFindExpert();
}
