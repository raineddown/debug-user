package com.design.user.application.outbound;

import com.design.user.adapter.inbound.dto.ExpertDTO;
import com.design.user.domain.Expert;

import java.util.List;

public interface ExpertRepository {
    //查看评审专家
    List<Expert> userFindExpert();
}
