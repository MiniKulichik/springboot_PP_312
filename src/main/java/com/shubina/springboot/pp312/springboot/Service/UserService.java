package com.shubina.springboot.pp312.springboot.Service;

import com.shubina.springboot.pp312.springboot.Model.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();

    public User getUser(int id);

    public void saveUser(User user);

    public void updateUser(int id, User updatedUser);

    public void deleteUser(int id);
}
