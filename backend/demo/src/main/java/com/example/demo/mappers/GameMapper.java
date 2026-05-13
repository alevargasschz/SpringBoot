package com.example.demo.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.example.demo.dto.GameResponse;
import com.example.demo.model.Game;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface GameMapper {
    @Mappings({
        //@Mapping(source = "user", target = "userId", qualifiedByName = "userId"),
        @Mapping(source = "createdBy", target = "userId", qualifiedByName = "userId"),
        @Mapping(source = "createdBy", target = "username", qualifiedByName = "userUsername")
    })
    GameResponse toDto(Game game);
    
    List<GameResponse> toDtoList(List<Game> games);
}
