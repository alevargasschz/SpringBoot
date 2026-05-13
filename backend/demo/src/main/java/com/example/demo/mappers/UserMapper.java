package com.example.demo.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Named;

import com.example.demo.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Named("userId")
    default Integer userId(User user) {
        return user.getId();
    }

    @Named("userUsername")
    default String userUsername(User user) {
        return user.getUsername();
    }
}
