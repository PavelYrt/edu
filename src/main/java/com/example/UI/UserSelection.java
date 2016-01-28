package com.example.UI;

import com.example.model.User;
import com.example.repository.UserRepository;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;

@SpringComponent
@UIScope
public class UserSelection {

    private final UserRepository userRepository;

    private User user;

    @Autowired
    public UserSelection(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

}
