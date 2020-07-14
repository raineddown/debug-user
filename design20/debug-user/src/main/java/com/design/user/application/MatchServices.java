package com.design.user.application;

import com.design.user.adapter.inbound.dto.MatchDTO;
import com.design.user.application.inbound.MatchUseCase;
import com.design.user.application.outbound.MatchRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class MatchServices implements MatchUseCase {
    @Autowired
    private final MatchRepository matchRepository;

    @Override
    public List<MatchDTO> findAllMatch() {
        return null;
    }

    @Override
    public MatchDTO findDetailMatch(int match_id) {
        return matchRepository.findDetailMatch(match_id);
    }
}
