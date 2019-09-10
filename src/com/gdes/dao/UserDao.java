package com.gdes.dao;

import com.gdes.domain.User;

import java.util.List;
import java.util.Map;

public interface UserDao {

    public List<User> findAll();

    User findUserByUsernameAndPassword(String username, String password);
}
