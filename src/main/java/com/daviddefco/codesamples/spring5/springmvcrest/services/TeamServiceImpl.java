package com.daviddefco.codesamples.spring5.springmvcrest.services;

import com.daviddefco.codesamples.spring5.springmvcrest.api.v1.mapper.TeamMapper;
import com.daviddefco.codesamples.spring5.springmvcrest.api.v1.model.TeamDto;
import com.daviddefco.codesamples.spring5.springmvcrest.api.v1.model.TeamListDto;
import com.daviddefco.codesamples.spring5.springmvcrest.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class TeamServiceImpl implements TeamService {

    @Autowired
    TeamRepository teamRepository;

    @Override
    public TeamListDto findAllTeams() {
        List<TeamDto> teamDtoList = new ArrayList<>();
        teamRepository.findAll().forEach(team -> {
            teamDtoList.add(TeamMapper.INSTANCE.teamToTeamDto(team));
        });
        return new TeamListDto(teamDtoList);
    }

    @Override
    public TeamListDto findAllTeamsFoundedAfter(Integer foundationYear) {
        return null;
    }
}
