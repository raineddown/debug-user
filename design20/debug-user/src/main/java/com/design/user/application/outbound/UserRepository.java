package com.design.user.application.outbound;

import com.design.user.adapter.inbound.dto.UserDTO;
import com.design.user.domain.User;

public interface UserRepository {
    //游客账户注册
    boolean addUser(User user);
    //企业认证用户
    boolean userUpload(int user_id, String password , String workplace, String company);
    //登录查询
    User findUserById(int user_id,String password);

    User findUserOnlyId(int user_id);

    User findUserByPhone(String phone,String password);
    //注册检查电话是否已经被注册
    User findPhone(String phone);
    //查看个人用户信息
    User userMessage(int user_id);

    //用户上传更新头像
    boolean uploadHead(int user_id,String img);

    //用户修改信息//
    boolean updateUserMessage(int user_id,String username);
}
