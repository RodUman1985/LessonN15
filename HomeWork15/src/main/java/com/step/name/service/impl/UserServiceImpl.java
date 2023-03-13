package com.step.name.service.impl;

import com.step.name.dao.UserDAO;
import com.step.name.dao.impl.UserDAOImpl;
import com.step.name.model.User;
import com.step.name.service.UserService;

import java.util.Optional;

public class UserServiceImpl implements UserService {
    private UserDAO userDAO = new UserDAOImpl();

    @Override
    public void createUser(User user) {
        userDAO.createNewUser(user);
    }

    @Override
    public Optional<User> getByName(String userName) {
        return userDAO.getUserByName(userName);
    }
}
