package com.daviddefco.codesamples.spring5.springmvcrest.controllers.v1;

import com.daviddefco.codesamples.spring5.springmvcrest.api.v1.model.TeamListDto;
import com.daviddefco.codesamples.spring5.springmvcrest.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/teams/")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @RequestMapping
    @ResponseStatus(HttpStatus.OK)
    public TeamListDto getAllTeams() {
        return teamService.findAllTeams();
    }

    @RequestMapping("{foundationYear}")
    @ResponseStatus(HttpStatus.OK)
    public TeamListDto getAllTeamsFoundedAfter(@PathVariable String foundationYear) {
        return teamService.findAllTeamsFoundedAfter(Integer.valueOf(foundationYear));
    }
}
