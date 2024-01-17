package com.services.user.service.impl;

import com.services.user.model.User;
import com.services.user.repository.IUserRepository;
import com.services.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    
    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {

       return  userRepository.addUser(user);

    }

    @Override
    public boolean updateUser(User user) {

        userRepository.updateUser(user);
        return true;
    }

    @Override
    public boolean deleteUser(String id) {
        userRepository.deleteUser(id);
        return true;
    }

    @Override
    public User getUser(String id) {

        return userRepository.getUser(id);
    }

    /**
     * @return
     */
    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

}
