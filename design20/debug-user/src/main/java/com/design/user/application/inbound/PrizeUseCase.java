package com.design.user.application.inbound;

import com.design.user.adapter.inbound.dto.MatchDTO;
import com.design.user.adapter.inbound.dto.PrizeDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PrizeUseCase {
    //查看个人所有获奖项目
    List<MatchDTO> userPrize(int user_id);
    //查看往年获奖项目
    List<MatchDTO> findAllPrize();

    List<PrizeDTO> onlyFindPrize(int project_id);
}
