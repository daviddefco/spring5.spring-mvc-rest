package com.daviddefco.codesamples.spring5.springmvcrest.controllers.v1;

import com.daviddefco.codesamples.spring5.springmvcrest.api.v1.model.TeamListDto;
import com.daviddefco.codesamples.spring5.springmvcrest.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/teams/")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @RequestMapping
    public ResponseEntity<TeamListDto> getAllTeams() {
        return new ResponseEntity<>(
            teamService.findAllTeams(),
            HttpStatus.OK
        );
    }

    @RequestMapping("{foundationYear}")
    public ResponseEntity<TeamListDto> getAllTeamsFoundedAfter(@PathVariable String foundationYear) {
        return new ResponseEntity<>(
            teamService.findAllTeamsFoundedAfter(Integer.valueOf(foundationYear)),
            HttpStatus.OK
        );
    }
}
