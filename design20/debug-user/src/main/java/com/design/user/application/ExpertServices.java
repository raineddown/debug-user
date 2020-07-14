package com.design.user.application;

import com.design.user.adapter.inbound.dto.ExpertDTO;
import com.design.user.application.inbound.ExpertUseCase;
import com.design.user.application.outbound.ExpertRepository;
import com.design.user.domain.Declare;
import com.design.user.domain.Expert;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class ExpertServices implements ExpertUseCase {
    @Autowired
    private final ExpertRepository expertRepository;

    @Override
    public List<ExpertDTO> userFindExpert() {
        return expertRepository.userFindExpert().stream()
                .map(Expert::makeExpertDTO)
                .collect(Collectors.toList());
    }
}
