package com.daviddefco.codesamples.spring5.springmvcrest.services;

import com.daviddefco.codesamples.spring5.springmvcrest.api.v1.mapper.PlayerMapper;
import com.daviddefco.codesamples.spring5.springmvcrest.api.v1.model.PlayerDto;
import com.daviddefco.codesamples.spring5.springmvcrest.api.v1.model.PlayerListDto;
import com.daviddefco.codesamples.spring5.springmvcrest.domain.Player;
import com.daviddefco.codesamples.spring5.springmvcrest.repositories.PlayerRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PlayerServiceTests {

    public static final String PLAYER_NAME = "Brandon Ingram";
    public static final long PLAYER_ID = 14;
    public static final String PAUL_GEORGE = "Paul George";

    @InjectMocks
    PlayerServiceImpl playerService;

    @Mock
    PlayerRepository playerRepository;

    @Mock
    PlayerMapper playerMapper;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findAllPlayersTest() {
        // given
        List<Player> playerList = Arrays.asList(new Player(), new Player());
        when(playerRepository.findAll()).thenReturn(playerList);

        // when
        PlayerListDto playerDtoList = playerService.findAllPlayers();

        // then
        assertEquals(2, playerDtoList.getPlayers().size());
    }

    @Test
    public void findByNameTest() {
        // given
        Player ingram = new Player();
        ingram.setId(PLAYER_ID);
        ingram.setName(PLAYER_NAME);
        when(playerRepository.findByName(anyString())).thenReturn(Optional.of(ingram));
        when(playerMapper.playerToPlayerDto(any())).thenReturn(PlayerMapper.INSTANCE.playerToPlayerDto(ingram));

        // when
        PlayerDto playerDto = playerService.findPlayerByName(PLAYER_NAME);

        // then
        assertNotNull(playerDto);
        assertEquals(PLAYER_ID, playerDto.getId().longValue());
    }

    @Test
    public void findPlayerById() {

        // given
        Player pg = new Player();
        pg.setId(PLAYER_ID);
        pg.setName(PAUL_GEORGE);
        when(playerRepository.findById(PLAYER_ID)).thenReturn(Optional.of(pg));
        when(playerMapper.playerToPlayerDto(any())).thenReturn(PlayerMapper.INSTANCE.playerToPlayerDto(pg));

        // when
        PlayerDto pgDto = playerService.findPlayerById(PLAYER_ID);

        // then
        assertEquals(PAUL_GEORGE, pgDto.getName());

    }

    @Test
    public void createPlayer() {
        // given
        Player pg = new Player();
        pg.setName("Paul George");
        when(playerRepository.save(any())).thenReturn(pg);

        // when
        playerService.savePlayer(new PlayerDto());

        // then
        verify(playerRepository, times(1)).save(any());
    }

    @Test
    public void deletePlayer() {
        // when
        playerService.deletePlayer(1L);

        // then
        verify(playerRepository, times(1)).deleteById(anyLong());
    }
}
