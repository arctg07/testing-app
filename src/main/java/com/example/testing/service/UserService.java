package com.example.testing.service;

import com.example.testing.model.UserDto;
import com.example.testing.model.ViewUser;

/**
 * @author Iurii Ivanov
 */

public interface UserService {

    void create(UserDto userDto);

    ViewUser getUser(UserDto userDto);

    void checkUserById(Long id);
}
