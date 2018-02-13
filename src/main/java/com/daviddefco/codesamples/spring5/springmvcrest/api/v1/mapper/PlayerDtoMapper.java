package com.daviddefco.codesamples.spring5.springmvcrest.api.v1.mapper;

import com.daviddefco.codesamples.spring5.springmvcrest.api.v1.model.PlayerDto;
import com.daviddefco.codesamples.spring5.springmvcrest.domain.Player;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PlayerDtoMapper {
    PlayerDtoMapper INSTANCE = Mappers.getMapper(PlayerDtoMapper.class);

    @Mapping(source = "priorExperience", target = "experience")
    @Mapping(source = "jerseyNumber", target = "number")
    @Mapping(source = "positionPlayed", target = "position")

    Player playerDtoToPlayer(PlayerDto ingramDto);
}
