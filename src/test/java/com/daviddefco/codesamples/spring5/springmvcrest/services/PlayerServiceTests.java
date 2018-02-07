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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

public class PlayerServiceTests {

    public static final String PLAYER_NAME = "Brandon Ingram";
    public static final long PLAYER_ID = 14;

    @InjectMocks
    PlayerServiceImpl playerService;

    @Mock
    PlayerRepository playerRepository;

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
        when(playerRepository.findByName(PLAYER_NAME)).thenReturn(ingram);

        // when
        PlayerDto playerDto = playerService.findPlayerByName(PLAYER_NAME);

        // then
        assertNotNull(playerDto);
        assertEquals(PLAYER_ID, playerDto.getId().longValue());
    }
}
