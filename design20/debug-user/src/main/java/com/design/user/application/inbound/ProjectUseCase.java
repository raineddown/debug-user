package com.design.user.application.inbound;

import com.design.user.adapter.inbound.dto.ProjectDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProjectUseCase {
    //项目提交
    boolean userSubmission(String name,String information,String type,String address,String images,String time,int user_id);
    //项目更新
    boolean userUpdateProject(String name,String type,String address,String time,int project_id,int user_id);
    //查看个人所有项目
    List<ProjectDTO> userAllProject(int user_id);
    //查看个人所有未审核项目
    List<ProjectDTO> userNewProject(int user_id);
    //查看个人所有审核中项目
    List<ProjectDTO> userExamineProject(int user_id);
    //查看个人所有审核完毕项目
    List<ProjectDTO> userFinalProject(int user_id);

    //项目详情//
    ProjectDTO detailProject(int project_id);

    //删除项目//
    boolean deletedProject(int project_id);

    //调用微服务检查是否可以申报//
    boolean checkDeclare();
}
