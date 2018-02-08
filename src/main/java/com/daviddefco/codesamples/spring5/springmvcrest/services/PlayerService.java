package com.daviddefco.codesamples.spring5.springmvcrest.services;

import com.daviddefco.codesamples.spring5.springmvcrest.api.v1.model.PlayerDto;
import com.daviddefco.codesamples.spring5.springmvcrest.api.v1.model.PlayerListDto;

import java.util.List;

public interface PlayerService {
    PlayerListDto findAllPlayers();
    PlayerDto findPlayerByName(String playerName);
    PlayerListDto findPlayersFromTeam(Long teamId);
}
