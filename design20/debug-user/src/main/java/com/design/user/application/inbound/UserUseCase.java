package com.design.user.application.inbound;

import com.design.user.adapter.inbound.dto.UserDTO;
import org.springframework.stereotype.Component;

@Component
public interface UserUseCase {
    //游客账户注册
    boolean addUser(UserDTO userDTO);
    //用户企业认证
    boolean userUpload(int user_id, String password , String workplace, String company);
    //登录查询
    UserDTO findUserById(int user_id,String password);
    //id查询//
    UserDTO findUserOnlyId(int user_id);
    //电话登录
    UserDTO findUserByPhone(String phone,String password);
    //注册检查电话是否已经被注册
    UserDTO findPhone(String phone);
    //查看个人用户信息
    UserDTO userMessage(int user_id);
    //上传头像//
    boolean uploadHead(int user_id,String img);
    //修改用户信息//
    boolean updateUserMessage(int user_id,String username);


}
