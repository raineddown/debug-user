package com.design.user.adapter.inbound.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDTO {
    private int project_id;
    private String pro_name;
    private String information;
    private String pro_type;
    private int state;
    private String address;
    private String images;  //项目文件
    private String time;
    private int user_id;

    public ProjectDTO(String pro_name, String information, String pro_type, String address, String images, String time, int user_id) {
        this.pro_name = pro_name;
        this.information = information;
        this.pro_type = pro_type;
        this.address = address;
        this.images = images;
        this.time = time;
        this.user_id = user_id;
        this.state = 0; //新创建类型//
    }

    public String translateState(int state){
        if(state == 0) return "未审核";
        else if(state == 1) return "审核中";
        else if(state == 2) return "已审核";
        else return "已删除";
    }
}
