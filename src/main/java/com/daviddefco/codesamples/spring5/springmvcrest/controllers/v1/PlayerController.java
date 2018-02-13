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

@Controller
@RequestMapping("/api/v1/players/")
public class PlayerController {

    public static final String EMPTY_RESPONSE = "";
    @Autowired
    private PlayerService playerService;

    @GetMapping
    public ResponseEntity<PlayerListDto> getAllPlayers() {
        return new ResponseEntity<>(
            playerService.findAllPlayers(),
            HttpStatus.OK
        );
    }

    @GetMapping("query")
    public ResponseEntity<PlayerDto> getPlayerByName(@RequestAttribute("name") String playerName) {
        return new ResponseEntity<>(
            playerService.findPlayerByName(playerName),
            HttpStatus.OK
        );
    }

    @GetMapping("/{playerId}")
    public ResponseEntity<PlayerDto> getPlayerById(@PathVariable String playerId) {
        return new ResponseEntity<>(
            playerService.findPlayerById(Long.valueOf(playerId)),
            HttpStatus.OK
        );
    }

    @GetMapping("teams/{teamId}")
    public ResponseEntity<PlayerListDto> getPlayersOfTeam(@PathVariable String teamId) {
        return new ResponseEntity<>(
            playerService.findPlayersFromTeam(Long.valueOf(teamId)),
            HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity<PlayerDto> savePlayer(@RequestBody PlayerDto player) {
        return new ResponseEntity<>(
            playerService.savePlayer(player),
            HttpStatus.CREATED
        );
    }

    @PutMapping("{playerId}")
    public ResponseEntity<PlayerDto> updatePlayer(
        @PathVariable String playerId,
        @RequestBody PlayerDto player
    ){
        player.setId(Long.valueOf(playerId));
        return new ResponseEntity<>(
            playerService.updatePlayer(player),
            HttpStatus.ACCEPTED
        );
    }

    @DeleteMapping("{playerId}")
    public ResponseEntity<String> deletePlayer(@PathVariable String playerId) {
        playerService.deletePlayer(Long.valueOf(playerId));
        return new ResponseEntity<>(EMPTY_RESPONSE, HttpStatus.OK);
    }

}
