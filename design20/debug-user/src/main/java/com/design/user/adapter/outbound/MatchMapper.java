package com.design.user.adapter.outbound;

import com.design.user.adapter.inbound.dto.MatchDTO;
import com.design.user.application.outbound.MatchRepository;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MatchMapper extends MatchRepository {
    @Override
    List<MatchDTO> findAllMatch();

    @Override
    MatchDTO findDetailMatch(int match_id);
}
