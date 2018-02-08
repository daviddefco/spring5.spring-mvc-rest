package com.daviddefco.codesamples.spring5.springmvcrest.controllers.v1;

import com.daviddefco.codesamples.spring5.springmvcrest.api.v1.model.TeamDto;
import com.daviddefco.codesamples.spring5.springmvcrest.api.v1.model.TeamListDto;
import com.daviddefco.codesamples.spring5.springmvcrest.services.TeamService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class TeamControllerTests {

    public static final String API_V1_TEAMS = "/api/v1/teams/";
    @Mock
    TeamService teamService;

    @InjectMocks
    TeamController teamController;

    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(teamController).build();
    }

    @Test
    public void getAllTeamsTest() throws Exception {

        // given
        List<TeamDto> teamList = Arrays.asList(new TeamDto(), new TeamDto());
        when(teamService.findAllTeams()).thenReturn(new TeamListDto(teamList));

        // then
        mockMvc.perform(get(API_V1_TEAMS)
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.teams", hasSize(2)));
    }

    @Test
    public void getTeamsFoundedAfterGivenDate() throws Exception {

        // given
        List<TeamDto> teamDtoList = new ArrayList<>();
        TeamDto lal = new TeamDto();
        lal.setName("Los Angeles Lakers");
        lal.setFounded(1948);
        TeamDto nyk = new TeamDto();
        nyk.setName("New York Knicks");
        nyk.setFounded(1946);
        TeamDto nop = new TeamDto();
        teamDtoList.add(lal);
        teamDtoList.add(nyk);
        when(teamService.findAllTeamsFoundedAfter(1960)).thenReturn(new TeamListDto(teamDtoList));

        // then
        mockMvc.perform(get(API_V1_TEAMS + "1960")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.teams", hasSize(2)))
            .andExpect(jsonPath("$.teams[0].name", equalTo("Los Angeles Lakers")));
    }
}
