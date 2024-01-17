package com.services.user.repository.impl;

import com.services.user.Utilities.GuidGenerator;
import com.services.user.model.User;
import com.services.user.repository.IUserRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class InMemoryUserRepository implements IUserRepository {

    Map<String , User> users = new HashMap<>();

    public InMemoryUserRepository()
    {
        String id= GuidGenerator.generate();
        users.put(id, new User(id, "John","Doe"));

        id= GuidGenerator.generate();
        users.put(id, new User(id, "Merry","Brown"));
        
        id= GuidGenerator.generate();
        users.put(id, new User(id, "Robert","Yam"));

        id= GuidGenerator.generate();
        users.put(id, new User(id, "Johnstone","Drake"));

    }

    /**
     * @param user
     *
     */
    @Override
    public User addUser(User user) {
        user.setId(GuidGenerator.generate());
        users.put(user.getId() ,  user);
        return user;
    }

    /**
     * @param user user to be updated
     */
    @Override
    public void updateUser(User user) {
        if(users.containsKey(user.getId()))
            users.replace(user.getId(), user);
        else throw new IllegalArgumentException("User not found");   
    }

    /**
     * @param id identification of the user
     * @return the user 
     */
    @Override
    public User getUser(String id) {
        return users.get(id);
    }

    /**
     * @param id identification of the user
     */
    @Override
    public void deleteUser(String id) {
        users.remove(id);
    }

    /**
     * @return list of all the users
     */
    @Override
    public List<User> getAllUsers() {

        return users.values().stream()
            .sorted(Comparator.comparing(User::getFirstName)
            .thenComparing(User::getLastName)
            .thenComparing(User::getId))
            .toList();
    }
}
