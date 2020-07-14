package com.design.user.application.outbound;

import com.design.user.adapter.inbound.dto.MatchDTO;
import com.design.user.adapter.inbound.dto.PrizeDTO;
import com.design.user.domain.Prize;

import java.util.List;

public interface PrizeRepository {
    //查看个人所有获奖项目
    List<MatchDTO> userPrize(int user_id);
    //查看往年获奖项目
    List<MatchDTO> findAllPrize();

    //
    List<Prize> onlyFindPrize(int project_id);
}
