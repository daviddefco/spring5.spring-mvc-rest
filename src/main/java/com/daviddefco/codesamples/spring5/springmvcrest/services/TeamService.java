package com.daviddefco.codesamples.spring5.springmvcrest.services;

import com.daviddefco.codesamples.spring5.springmvcrest.api.v1.model.TeamDto;
import com.daviddefco.codesamples.spring5.springmvcrest.api.v1.model.TeamListDto;

import java.util.List;

public interface TeamService {
    TeamListDto findAllTeams();
    TeamListDto findAllTeamsFoundedAfter(Integer foundationYear);
}
