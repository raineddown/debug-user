package com.design.user.application.outbound;

import com.design.user.adapter.inbound.dto.ProjectDTO;
import com.design.user.domain.Project;

import java.util.List;

public interface ProjectRepository {
    //项目提交
    boolean userSubmission(String name,String information,String type,String address,String images,String time,int user_id);
    //项目更新
    boolean userUpdateProject(String name,String type,String address,String time,int project_id,int user_id);
    //查看个人所有项目
    List<Project> userAllProject(int user_id);
    //查看个人所有未审核项目
    List<Project> userNewProject(int user_id);
    //查看个人所有审核中项目
    List<Project> userExamineProject(int user_id);
    //查看个人所有审核完毕项目
    List<Project> userFinalProject(int user_id);

    //项目详情
    Project detailProject(int project_id);

    //删除项目//
    boolean deletedProject(int project_id);

}
