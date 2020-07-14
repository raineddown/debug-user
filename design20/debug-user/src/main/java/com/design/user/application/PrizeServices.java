package com.design.user.application;

import com.design.user.adapter.inbound.dto.MatchDTO;
import com.design.user.adapter.inbound.dto.PrizeDTO;

import com.design.user.application.inbound.PrizeUseCase;
import com.design.user.application.outbound.PrizeRepository;
import com.design.user.domain.Expert;
import com.design.user.domain.Prize;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class PrizeServices implements PrizeUseCase {
    @Autowired
    private final PrizeRepository prizeRepository;

    @Override
    public List<MatchDTO> userPrize(int user_id) {
        return prizeRepository.userPrize(user_id);
    }

    @Override
    public List<MatchDTO> findAllPrize() {
        return prizeRepository.findAllPrize();
    }

    @Override
    public List<PrizeDTO> onlyFindPrize(int project_id) {
        return prizeRepository.onlyFindPrize(project_id).stream()
                .map(Prize::makePrizeDTO)
                .collect(Collectors.toList());
    }
}
