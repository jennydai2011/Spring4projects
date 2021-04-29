package com.jdai.SpringBootBLog.service;

import com.jdai.SpringBootBLog.po.User;

public interface UserService {
    public User checkuser(String username, String password);
}
