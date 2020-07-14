package com.design.user.application;

import com.design.user.adapter.inbound.dto.DeclareDTO;
import com.design.user.application.inbound.DeclareUseCase;
import com.design.user.application.outbound.DeclareRepository;
import com.design.user.domain.Collections;
import com.design.user.domain.Declare;
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
    public List<DeclareDTO> enableDeclareType(String mat_type) {
        return declareRepository.enableDeclareType(mat_type);
    }
}
