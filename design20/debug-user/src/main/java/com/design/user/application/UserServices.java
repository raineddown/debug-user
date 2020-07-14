package com.design.user.application;

import com.design.user.adapter.inbound.dto.UserDTO;
import com.design.user.application.inbound.UserUseCase;
import com.design.user.application.outbound.UserRepository;
import com.design.user.domain.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class UserServices implements UserUseCase {

    @Autowired
    private final UserRepository userRepository;

    @Override
    public boolean addUser(UserDTO userDTO) {
        String username = userDTO.getUsername();
        String password = userDTO.getPassword();
        String phone = userDTO.getPhone();
        String registerTime = userDTO.getRegisterTime();
        User user = new User(username,password,phone,registerTime);
        return userRepository.addUser(user);
    }

    @Override
    public boolean userUpload(int user_id, String password , String workplace, String company) {
        userRepository.userUpload(user_id, password, workplace, company);
        return true;
    }

    @Override
    public UserDTO findUserById(int user_id,String password) {
        User user = userRepository.findUserById(user_id,password);
        if(user == null){
            return null;
        }
        return user.makeUserDTO();
    }

    @Override
    public UserDTO findUserOnlyId(int user_id) {
        User user = userRepository.findUserOnlyId(user_id);
        return user.makeUserDTO();
    }

    @Override
    public UserDTO findUserByPhone(String phone,String password) {
        User user = userRepository.findUserByPhone(phone,password);
        if(user == null){
            return null;
        }
        return user.makeUserDTO();
    }

    @Override
    public UserDTO findPhone(String phone) {
        User user = userRepository.findPhone(phone);
        if(user == null){
            return null;
        }
        return user.makeUserDTO();
    }

    @Override
    public UserDTO userMessage(int user_id) {
        User user = userRepository.userMessage(user_id);
        return user.makeUserDTO();
    }

    @Override
    public boolean uploadHead(int user_id,String img) {
        return userRepository.uploadHead(user_id,img);
    }

    @Override
    public boolean updateUserMessage(int user_id, String username) {
        return userRepository.updateUserMessage(user_id,username);
    }
}
