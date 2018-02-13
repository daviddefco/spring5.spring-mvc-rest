package com.daviddefco.codesamples.spring5.springmvcrest.controllers.v1;

import com.daviddefco.codesamples.spring5.springmvcrest.api.v1.model.PlayerDto;
import com.daviddefco.codesamples.spring5.springmvcrest.api.v1.model.PlayerListDto;
import com.daviddefco.codesamples.spring5.springmvcrest.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/players/")
public class PlayerController {

    public static final String EMPTY_RESPONSE = "";
    @Autowired
    private PlayerService playerService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public PlayerListDto getAllPlayers() {
        return playerService.findAllPlayers();
    }

    @GetMapping("query")
    @ResponseStatus(HttpStatus.OK)
    public PlayerDto getPlayerByName(@RequestAttribute("name") String playerName) {
        return playerService.findPlayerByName(playerName);
    }

    @GetMapping("/{playerId}")
    @ResponseStatus(HttpStatus.OK)
    public PlayerDto getPlayerById(@PathVariable String playerId) {
        return playerService.findPlayerById(Long.valueOf(playerId));
    }

    @GetMapping("teams/{teamId}")
    @ResponseStatus(HttpStatus.OK)
    public PlayerListDto getPlayersOfTeam(@PathVariable String teamId) {
        return playerService.findPlayersFromTeam(Long.valueOf(teamId));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PlayerDto savePlayer(@RequestBody PlayerDto player) {
        return playerService.savePlayer(player);
    }

    @PutMapping("{playerId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public PlayerDto updatePlayer(
        @PathVariable String playerId,
        @RequestBody PlayerDto player
    ){
        player.setId(Long.valueOf(playerId));
        return playerService.updatePlayer(player);
    }

    @DeleteMapping("{playerId}")
    @ResponseStatus(HttpStatus.OK)
    public String deletePlayer(@PathVariable String playerId) {
        playerService.deletePlayer(Long.valueOf(playerId));
        return EMPTY_RESPONSE;
    }

}
