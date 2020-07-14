package com.design.check.adapter.outbound;

import com.design.check.adapter.inbound.DeclareDTO;
import com.design.check.application.outbound.DeclareRepository;
import com.design.check.domain.Declare;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeclareMapper extends DeclareRepository {
    @Override
    boolean checkDeclare(int begin_id);

    @Override
    boolean backDeclare(int begin_id);

    @Override
    List<Declare> findAllId();
}
