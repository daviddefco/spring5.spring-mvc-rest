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
        List<PlayerDto> players = new ArrayList<>();
        playerRepository.findAll().forEach(player -> {
            players.add(PlayerMapper.INSTANCE.playerToPlayerDto(player));
        });
        return new PlayerListDto(players);
    }

    @Override
    public PlayerDto findPlayerByName(String playerName) {
        return PlayerMapper.INSTANCE.playerToPlayerDto(
            playerRepository.findByName(playerName)
        );
    }

    @Override
    public PlayerListDto findPlayersFromTeam(Long teamId) {
        List<PlayerDto> players = new ArrayList<>();
        playerRepository.findAll().forEach(player-> {
            if (player.getPlaysFor().getId().equals(teamId)) {
                players.add(PlayerMapper.INSTANCE.playerToPlayerDto(player));
            }
        });
        return new PlayerListDto(players);
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
    public Optional<PlayerDto> findPlayerById(Long playerId) {
        Optional<Player> player  = playerRepository.findById(playerId);
        return player.isPresent() ?
            Optional.of(PlayerMapper.INSTANCE.playerToPlayerDto(player.get()))
            : Optional.empty();
    }

    @Override
    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }
}
