package com.gdes.service.impl;

import com.gdes.dao.UserDao;
import com.gdes.dao.impl.UserDaoImpl;
import com.gdes.domain.User;
import com.gdes.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService{
    private UserDao dao = new UserDaoImpl();

    @Override
    public List<User> findAll() {
        return dao.findAll();
    }

    @Override
    public User login(User user) {
        return dao.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }
}
