package com.projectx.crudapp.services;

import com.projectx.crudapp.repositories.UserRepository;
import com.projectx.crudapp.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Transactional
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }
    @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    @Transactional
    public User updateUser(Long studentId, User student) {
        student.setId(studentId);
        return userRepository.save(student);
    }


}
