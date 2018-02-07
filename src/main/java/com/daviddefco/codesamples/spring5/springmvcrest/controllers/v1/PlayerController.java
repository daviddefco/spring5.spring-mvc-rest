package com.daviddefco.codesamples.spring5.springmvcrest.controllers.v1;

import com.daviddefco.codesamples.spring5.springmvcrest.api.v1.model.PlayerDto;
import com.daviddefco.codesamples.spring5.springmvcrest.api.v1.model.PlayerListDto;
import com.daviddefco.codesamples.spring5.springmvcrest.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/players/")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping
    public ResponseEntity<PlayerListDto> getAllPlayers() {
        return new ResponseEntity<>(
            playerService.findAllPlayers(),
            HttpStatus.OK
        );
    }

    @GetMapping("{playerName}")
    public ResponseEntity<PlayerDto> getPlayerByName(@PathVariable String playerName) {
        return new ResponseEntity<>(
            playerService.findPlayerByName(playerName),
            HttpStatus.OK
        );
    }
}
