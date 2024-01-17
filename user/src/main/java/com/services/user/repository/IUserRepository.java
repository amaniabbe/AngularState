package com.services.user.repository;

import com.services.user.model.User;

import java.util.List;

public interface IUserRepository {
    public User addUser(User user);
    public void updateUser(User user);
    public User getUser(String id);
    public void  deleteUser(String id );
    public List<User> getAllUsers();
}
