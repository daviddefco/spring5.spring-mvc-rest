package com.daviddefco.codesamples.spring5.springmvcrest.services;

import com.daviddefco.codesamples.spring5.springmvcrest.api.v1.mapper.PlayerDtoMapper;
import com.daviddefco.codesamples.spring5.springmvcrest.api.v1.mapper.PlayerMapper;
import com.daviddefco.codesamples.spring5.springmvcrest.api.v1.model.PlayerDto;
import com.daviddefco.codesamples.spring5.springmvcrest.api.v1.model.PlayerListDto;
import com.daviddefco.codesamples.spring5.springmvcrest.domain.Player;
import com.daviddefco.codesamples.spring5.springmvcrest.repositories.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static java.util.stream.StreamSupport.stream;

@Service
public class PlayerServiceImpl implements PlayerService {

    private PlayerMapper playerMapper;
    private PlayerRepository playerRepository;

    public PlayerServiceImpl(PlayerMapper playerMapper, PlayerRepository playerRepository) {
        this.playerMapper = playerMapper;
        this.playerRepository = playerRepository;
    }

    @Override
    public PlayerListDto findAllPlayers() {
        return new PlayerListDto(stream(playerRepository.findAll().spliterator(), false)
            .map(playerMapper::playerToPlayerDto)
            .collect(Collectors.toList()));
    }

    @Override
    public PlayerDto findPlayerByName(String playerName) {
        return playerRepository.findByName(playerName)
            .map(playerMapper::playerToPlayerDto)
            .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public PlayerListDto findPlayersFromTeam(Long teamId) {
        return new PlayerListDto(stream(playerRepository.findAll().spliterator(), false)
            .filter(player -> player.getPlaysFor().getId() == teamId)
            .map(playerMapper::playerToPlayerDto)
            .collect(Collectors.toList()));
    }

    @Override
    public PlayerDto savePlayer(PlayerDto newPlayer) {
        return PlayerMapper.INSTANCE.playerToPlayerDto(
            playerRepository.save(PlayerDtoMapper.INSTANCE.playerDtoToPlayer(newPlayer))
        );
    }

    @Override
    public PlayerDto updatePlayer(PlayerDto updatedPlayer) {
        return PlayerMapper.INSTANCE.playerToPlayerDto(
            playerRepository.save(PlayerDtoMapper.INSTANCE.playerDtoToPlayer(updatedPlayer))
        );
    }

    @Override
    public PlayerDto findPlayerById(Long playerId) {
        return playerRepository.findById(playerId)
            .map(playerMapper::playerToPlayerDto)
            .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }
}
