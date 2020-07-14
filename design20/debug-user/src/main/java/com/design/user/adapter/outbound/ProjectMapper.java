package com.design.user.adapter.outbound;

import com.design.user.adapter.inbound.dto.ProjectDTO;
import com.design.user.application.outbound.ProjectRepository;
import com.design.user.domain.Project;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProjectMapper extends ProjectRepository {
    @Override
    boolean userSubmission(String name,String information,String type,String address,String images,String time,int user_id);

    @Override
    boolean userUpdateProject(String name,String type,String address,String time,int project_id,int user_id);

    @Override
    List<Project> userAllProject(int user_id);

    @Override
    List<Project> userNewProject(int user_id);

    @Override
    List<Project> userExamineProject(int user_id);

    @Override
    List<Project> userFinalProject(int user_id);

    @Override
    Project detailProject(int project_id);

    @Override
    boolean deletedProject(int project_id);
}
