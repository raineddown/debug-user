package com.design.user.adapter.outbound;

import com.design.user.adapter.inbound.dto.DeclareDTO;
import com.design.user.application.outbound.DeclareRepository;
import com.design.user.domain.Declare;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeclareMapper extends DeclareRepository {
    @Override
    List<DeclareDTO> enableDeclareType(String mat_type);
}
