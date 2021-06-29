package com.alisher.project.controllers;

import com.alisher.project.models.User;
import com.alisher.project.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping(UserController.ROOT_URL)
@RestController
public class UserController {
    public static final String ROOT_URL = "/user";
    public static final String CREATE_USER_URL = "/create";

    private final UserService userService;

    @PostMapping(CREATE_USER_URL)
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
}
