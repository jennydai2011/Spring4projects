package com.jdai.SpringBootBLog.service;

import com.jdai.SpringBootBLog.dao.UserRepository;
import com.jdai.SpringBootBLog.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;

    @Override
    public User checkuser(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, password);
        return user;
    }
}
