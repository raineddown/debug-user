package com.design.user.adapter.outbound;

import com.design.user.adapter.inbound.dto.UserDTO;
import com.design.user.application.outbound.UserRepository;
import com.design.user.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper extends UserRepository {
    @Override
    boolean addUser(User user);

    @Override
    boolean userUpload(int user_id, String password , String workplace, String company);

    @Override
    User findUserById(int user_id,String password);

    @Override
    User findUserOnlyId(int user_id);

    @Override
    User findUserByPhone(String phone,String password);

    @Override
    User findPhone(String phone);

    @Override
    User userMessage(int user_id);

    @Override
    boolean uploadHead(int user_id,String img);

    @Override
    boolean updateUserMessage(int user_id, String username);
}
