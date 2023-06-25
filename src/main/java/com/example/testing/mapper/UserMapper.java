package com.example.testing.mapper;

import com.example.testing.config.MapperConfig;
import com.example.testing.database.entity.User;
import com.example.testing.model.UserDto;
import com.example.testing.model.ViewUser;
import org.mapstruct.Mapper;

/**
 * @author Iurii Ivanov
 */

@Mapper(config = MapperConfig.class)
public interface UserMapper {

    User toEntity(UserDto userDto);

    ViewUser toView(User user);
}
