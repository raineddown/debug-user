package com.design.check.application.inbound;

import com.design.check.adapter.inbound.DeclareDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DeclareUseCase {
    boolean checkDeclare(int begin_id);

    boolean backDeclare(int begin_id);

    List<DeclareDTO> findAllId();
}
