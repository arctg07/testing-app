package com.example.testing.service.impl;

import com.example.testing.database.entity.User;
import com.example.testing.database.repository.UserRepository;
import com.example.testing.exception.InvalidCredentialsException;
import com.example.testing.exception.InvalidLoginException;
import com.example.testing.exception.NotFoundException;
import com.example.testing.mapper.UserMapper;
import com.example.testing.model.UserDto;
import com.example.testing.model.ViewUser;
import com.example.testing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Iurii Ivanov
 */

@Service
public class UserServiceImpl implements UserService {

    public UserServiceImpl(@Autowired UserRepository userRepository, @Autowired UserMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    private final UserRepository userRepository;
    private final UserMapper mapper;

    @Override
    public void create(UserDto userDto) {
        checkLoginPresent(userDto.login());

        User user = mapper.toEntity(userDto);
        userRepository.save(user);
    }

    @Override
    public ViewUser getUser(UserDto userDto) {
        String login = userDto.login();
        String password = userDto.password();

        User user = userRepository.findByLogin(login).orElseThrow(
                InvalidCredentialsException::new);

        if (!user.getPassword().equals(password)) throw new InvalidCredentialsException();

        return mapper.toView(user);
    }

    public void checkUserById(Long id) {
        if (!userRepository.existsById(id)) throw new NotFoundException(User.class, id.toString());
    }

    private void checkLoginPresent(String login) {
        if (userRepository.existsByLogin(login)) throw new InvalidLoginException(login);
    }
}
