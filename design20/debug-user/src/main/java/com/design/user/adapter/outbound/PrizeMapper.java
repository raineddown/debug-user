package com.design.user.adapter.outbound;

import com.design.user.adapter.inbound.dto.MatchDTO;
import com.design.user.adapter.inbound.dto.PrizeDTO;
import com.design.user.application.outbound.PrizeRepository;
import com.design.user.domain.Prize;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PrizeMapper extends PrizeRepository {
    @Override
    List<MatchDTO> userPrize(int user_id);

    @Override
    List<MatchDTO> findAllPrize();

    @Override
    List<Prize> onlyFindPrize(int project_id);
}
