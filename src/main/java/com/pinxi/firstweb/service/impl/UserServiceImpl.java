package com.pinxi.firstweb.service.impl;

import com.pinxi.firstweb.dao.impl.UserDaoImpl;
import com.pinxi.firstweb.entity.User;
import com.pinxi.firstweb.service.UserService;

public class UserServiceImpl implements UserService {

    @Override
    public User checkUser(User user) {
        UserDaoImpl userDao = new UserDaoImpl();
        return userDao.checkUser(user);
    }
}
