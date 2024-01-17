package com.services.user.service;

import com.services.user.model.User;

import java.util.List;

public interface IUserService {
    public User createUser(User user);
    public boolean updateUser(User user);
    public boolean deleteUser(String id);

    public  User getUser(String id);
    public List<User> getAllUsers();

}
