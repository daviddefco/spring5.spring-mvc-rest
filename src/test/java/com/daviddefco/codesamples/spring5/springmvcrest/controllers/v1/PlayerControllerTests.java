package com.daviddefco.codesamples.spring5.springmvcrest.controllers.v1;

import com.daviddefco.codesamples.spring5.springmvcrest.api.v1.model.PlayerDto;
import com.daviddefco.codesamples.spring5.springmvcrest.api.v1.model.PlayerListDto;
import com.daviddefco.codesamples.spring5.springmvcrest.domain.Player;
import com.daviddefco.codesamples.spring5.springmvcrest.services.PlayerService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class PlayerControllerTests {

    public static final long PLAYER_ID = 6L;
    public static final String PLAYER_NAME = "Jordan Clarkson";
    public static final String API_V1_PLAYERS = "/api/v1/players/";

    @Mock
    PlayerService playerService;

    @InjectMocks
    PlayerController playerController;

    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(playerController).build();
    }

    @Test
    public void listPlayersTest() throws Exception {
        // given
        List<PlayerDto> playerDtoList = Arrays.asList(new PlayerDto(), new PlayerDto());
        when(playerService.findAllPlayers()).thenReturn(new PlayerListDto(playerDtoList));

        // then
        mockMvc.perform(get(API_V1_PLAYERS)
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.players", hasSize(2)));
    }

    @Test
    public void playerByNameTest() throws Exception {
        // given
        PlayerDto clarkson = new PlayerDto();
        clarkson.setId(PLAYER_ID);
        clarkson.setName(PLAYER_NAME);
        when(playerService.findPlayerByName(PLAYER_NAME)).thenReturn(clarkson);

        // then
        mockMvc.perform(get(API_V1_PLAYERS + PLAYER_NAME)
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.name", equalTo(PLAYER_NAME)))
            .andExpect(jsonPath("$.id").value(PLAYER_ID));
    }
}
