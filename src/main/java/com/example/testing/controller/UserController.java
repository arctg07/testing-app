package com.example.testing.controller;

import com.example.testing.model.UserDto;
import com.example.testing.model.ViewUser;
import com.example.testing.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Iurii Ivanov
 */

@RestController
@RequestMapping("/testing/user")
@Tag(name = "User controller", description = "API for work with user-service")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    @Operation(summary = "SIGN UP", description = "CREATE NEW USER")
    public void create(UserDto userDto) {
        userService.create(userDto);
    }

    @PostMapping("/login")
    @Operation(summary = "LOG IN", description = "GET USER BY CREDENTIALS")
    public ViewUser getUser(UserDto userDto) {
        return userService.getUser(userDto);
    }
}
