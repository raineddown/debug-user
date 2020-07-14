package com.design.check.application;

import com.design.check.adapter.inbound.DeclareDTO;
import com.design.check.application.inbound.DeclareUseCase;
import com.design.check.application.outbound.DeclareRepository;
import com.design.check.domain.Declare;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class DeclareServices implements DeclareUseCase {
    @Autowired
    private final DeclareRepository declareRepository;

    @Override
    public boolean checkDeclare(int begin_id) {
        return declareRepository.checkDeclare(begin_id);
    }

    @Override
    public boolean backDeclare(int begin_id) {
        return declareRepository.backDeclare(begin_id);
    }

    @Override
    public List<DeclareDTO> findAllId() {
        return declareRepository.findAllId().stream()
                .map(Declare::makeDeclareDTO)
                .collect(Collectors.toList());
    }
}
