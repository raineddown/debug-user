package com.design.user.application.outbound;

import com.design.user.adapter.inbound.dto.MatchDTO;

import java.util.List;

public interface MatchRepository {
    //查看所有奖项
    List<MatchDTO> findAllMatch();
    //单个奖项详细信息
    MatchDTO findDetailMatch(int match_id);
}
