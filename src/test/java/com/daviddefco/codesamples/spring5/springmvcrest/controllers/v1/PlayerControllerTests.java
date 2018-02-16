package com.daviddefco.codesamples.spring5.springmvcrest.controllers.v1;

import com.daviddefco.codesamples.spring5.springmvcrest.api.v1.model.PlayerDto;
import com.daviddefco.codesamples.spring5.springmvcrest.api.v1.model.PlayerListDto;
import com.daviddefco.codesamples.spring5.springmvcrest.controllers.RestResponseEntityExceptionHandler;
import com.daviddefco.codesamples.spring5.springmvcrest.services.PlayerService;
import com.daviddefco.codesamples.spring5.springmvcrest.services.ResourceNotFoundException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class PlayerControllerTests {

    public static final long PLAYER_ID = 6L;
    public static final String PLAYER_NAME = "Jordan Clarkson";
    public static final String API_V1_PLAYERS = "/api/v1/players/";
    public static final String LEBRON_JAMES = "Lebron James";
    public static final String KARL_ANTONY_TOWNS = "Karl Antony Towns";

    @Mock
    PlayerService playerService;

    @InjectMocks
    PlayerController playerController;

    MockMvc mockMvc;
    ObjectMapper jsonMapper;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
            .standaloneSetup(playerController)
            .setControllerAdvice(new RestResponseEntityExceptionHandler())
            .build();
        jsonMapper = new ObjectMapper();
    }

    @Test
    public void listPlayersTest() throws Exception {
        // given
        List<PlayerDto> playerDtoList = Arrays.asList(new PlayerDto(), new PlayerDto());
        when(playerService.findAllPlayers()).thenReturn(new PlayerListDto(playerDtoList));

        // then
        mockMvc.perform(get(API_V1_PLAYERS)
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
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
        mockMvc.perform(get(API_V1_PLAYERS + "query")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
            .requestAttr("name", PLAYER_NAME))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.name", equalTo(PLAYER_NAME)))
            .andExpect(jsonPath("$.id").value(PLAYER_ID));
    }

    @Test
    public void playerByNameNotFound() throws Exception {
        // given
        when(playerService.findPlayerByName(anyString())).thenThrow(new ResourceNotFoundException());

        // then
        mockMvc.perform(get(API_V1_PLAYERS + "query")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
            .requestAttr("name", PLAYER_NAME))
            .andExpect(status().isNotFound());
    }


    @Test
    public void playerByIdTest() throws Exception {
        // given
        PlayerDto kat = new PlayerDto();
        kat.setName(KARL_ANTONY_TOWNS);
        kat.setId(PLAYER_ID);
        when(playerService.findPlayerById(PLAYER_ID)).thenReturn(kat);

        //then
        mockMvc.perform(get(API_V1_PLAYERS + PLAYER_ID)
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.name", equalTo(KARL_ANTONY_TOWNS)))
            .andExpect(jsonPath("$.id").value(PLAYER_ID));
    }

    @Test
    public void playerByIdNotFound() throws Exception {
        // given
        when(playerService.findPlayerById(anyLong())).thenThrow(new ResourceNotFoundException());

        // then
        mockMvc.perform(get(API_V1_PLAYERS + PLAYER_ID)
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNotFound());
    }

    @Test
    public void createNewPlayerTest() throws Exception {

        // given
        PlayerDto lbj = new PlayerDto();
        lbj.setName(LEBRON_JAMES);
        when(playerService.savePlayer(any())).thenReturn(lbj);

        // then
        mockMvc.perform(post(API_V1_PLAYERS)
            .contentType(MediaType.APPLICATION_JSON)
            .content(jsonMapper.writeValueAsString(lbj))
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.name", equalTo(LEBRON_JAMES)));

    }

    @Test
    public void updatePlayerTest() throws Exception {

        // given
        PlayerDto lbj = new PlayerDto();
        lbj.setName(LEBRON_JAMES);
        when(playerService.updatePlayer(any())).thenReturn(lbj);

        // then
        mockMvc.perform(put(API_V1_PLAYERS + "/1")
            .contentType(MediaType.APPLICATION_JSON)
            .content(jsonMapper.writeValueAsString(lbj))
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isAccepted())
            .andExpect(jsonPath("$.name", equalTo(LEBRON_JAMES)));

    }

    @Test
    public void deletePlayerTest() throws Exception {

        // when - then
        mockMvc.perform(delete(API_V1_PLAYERS + "/1")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());

    }
}
