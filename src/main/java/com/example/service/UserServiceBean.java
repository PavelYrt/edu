package com.example.service;

import com.example.model.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserServiceBean implements LibraryServices<User, Long> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Collection<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findOne(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        User userToUpdate = findOne(user.getId());
        if (userToUpdate == null) {
            return null;
        }

        userToUpdate.setUserFullName(user.getUserFullName());
        return userRepository.save(userToUpdate);
    }

    @Override
    public void delete(Long id) {
        userRepository.delete(id);
    }
}
