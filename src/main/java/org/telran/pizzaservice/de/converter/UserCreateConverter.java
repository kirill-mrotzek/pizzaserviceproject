package org.telran.pizzaservice.de.converter;

import org.springframework.stereotype.Component;
import org.telran.pizzaservice.de.dto.UserCreateDto;
import org.telran.pizzaservice.de.dto.UserResponseDto;
import org.telran.pizzaservice.de.entity.User;

@Component
public class UserCreateConverter implements Converter<User, UserCreateDto, UserResponseDto>{

    @Override
    public UserResponseDto toDto(User user) {
        return new UserResponseDto(user.getId(), user.getName(), user.getEmail());
    }

    @Override
    public User toEntity(UserCreateDto userCreateDto) {
        return new User(userCreateDto.getLogin(), userCreateDto.getPassword(), userCreateDto.getEmail());
    }
}
