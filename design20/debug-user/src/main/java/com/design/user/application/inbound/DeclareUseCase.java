package com.design.user.application.inbound;

import com.design.user.adapter.inbound.dto.DeclareDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DeclareUseCase {
    List<DeclareDTO> enableDeclareType(String mat_type);
}
