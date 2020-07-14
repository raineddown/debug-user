package com.design.user.domain;

import com.design.user.adapter.inbound.dto.ProjectDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Project {
    private int project_id;
    private String pro_name;
    private String information;
    private String pro_type;
    private int state;
    private String address;
    private String images;  //项目文件
    private String time;
    private int user_id;

    public ProjectDTO makeProjectDTO(){
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setProject_id(project_id);
        projectDTO.setPro_name(pro_name);
        projectDTO.setInformation(information);
        projectDTO.setPro_type(pro_type);
        projectDTO.setState(state);
        projectDTO.setAddress(address);
        projectDTO.setImages(images);
        projectDTO.setTime(time);
        projectDTO.setUser_id(user_id);
        return projectDTO;
    }
}
