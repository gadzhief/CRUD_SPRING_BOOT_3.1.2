package com.projectx.crudapp.services;

import com.projectx.crudapp.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    List<User> getUsers();
    User getUserById(Long id);

    void deleteUser(Long id);

    User updateUser(Long studentId, User student);


}
