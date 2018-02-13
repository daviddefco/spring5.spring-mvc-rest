package com.daviddefco.codesamples.spring5.springmvcrest.services;

import com.daviddefco.codesamples.spring5.springmvcrest.api.v1.model.PlayerDto;
import com.daviddefco.codesamples.spring5.springmvcrest.api.v1.model.PlayerListDto;
import com.daviddefco.codesamples.spring5.springmvcrest.domain.Player;

import java.util.List;
import java.util.Optional;

public interface PlayerService {
    PlayerListDto findAllPlayers();
    PlayerDto findPlayerByName(String playerName);
    PlayerListDto findPlayersFromTeam(Long teamId);
    PlayerDto savePlayer(PlayerDto newPlayer);
    PlayerDto updatePlayer(PlayerDto updatedPlayer);
    PlayerDto findPlayerById(Long playerId);
    void deletePlayer(Long id);
}
