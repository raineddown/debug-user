package com.design.check.application.outbound;

import com.design.check.adapter.inbound.DeclareDTO;
import com.design.check.domain.Declare;

import java.util.List;

public interface DeclareRepository {
    boolean checkDeclare(int begin_id);

    boolean backDeclare(int begin_id);

    List<Declare> findAllId();
}
