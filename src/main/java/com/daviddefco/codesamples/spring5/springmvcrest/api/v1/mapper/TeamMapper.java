package com.daviddefco.codesamples.spring5.springmvcrest.api.v1.mapper;

import com.daviddefco.codesamples.spring5.springmvcrest.api.v1.model.TeamDto;
import com.daviddefco.codesamples.spring5.springmvcrest.domain.Team;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TeamMapper {

    TeamMapper INSTANCE = Mappers.getMapper(TeamMapper.class);

    @Mapping(source = "arena", target="playsAt")
    TeamDto teamToTeamDto(Team team);
}
