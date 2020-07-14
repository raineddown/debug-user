package com.design.user.application.inbound;

import com.design.user.adapter.inbound.dto.MatchDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MatchUseCase {
    //查看所有奖项
    List<MatchDTO> findAllMatch();
    //单个奖项详细信息
    MatchDTO findDetailMatch(int match_id);
}
