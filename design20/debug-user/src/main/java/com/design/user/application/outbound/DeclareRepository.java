package com.design.user.application.outbound;

import com.design.user.adapter.inbound.dto.DeclareDTO;
import com.design.user.domain.Declare;

import java.util.List;

public interface DeclareRepository {
    List<DeclareDTO> enableDeclareType(String mat_type);
}
