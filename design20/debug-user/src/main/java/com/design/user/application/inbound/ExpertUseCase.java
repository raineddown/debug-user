package com.design.user.application.inbound;

import com.design.user.adapter.inbound.dto.ExpertDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ExpertUseCase {
    //查看评审专家
    List<ExpertDTO> userFindExpert();
}
