package com.daviddefco.codesamples.spring5.springmvcrest.services;

import com.daviddefco.codesamples.spring5.springmvcrest.api.v1.model.TeamDto;
import com.daviddefco.codesamples.spring5.springmvcrest.api.v1.model.TeamListDto;
import com.daviddefco.codesamples.spring5.springmvcrest.domain.Team;
import com.daviddefco.codesamples.spring5.springmvcrest.repositories.TeamRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class TeamServiceTests {

    public static final int FOUNDED_1949 = 1949;
    public static final int FOUNDED_1950 = 1950;
    @InjectMocks
    TeamServiceImpl teamService;

    @Mock
    TeamRepository teamRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findAllTeamsTest() {

        // given
        List<Team> teamList = Arrays.asList(new Team(), new Team());
        when(teamRepository.findAll()).thenReturn(teamList);

        // when
        TeamListDto teamDtoList = teamService.findAllTeams();

        // then
        assertEquals(2, teamDtoList.getTeams().size());
    }

    @Test
    public void findAllTeamsFoundedAfterTest() {

        // given
        List<Team> teamList = Arrays.asList(new Team(), new Team());
        when(teamRepository.findByFoundedGreaterThan(FOUNDED_1950)).thenReturn(teamList);

        // when
        TeamListDto teamListDto = teamService.findAllTeamsFoundedAfter(FOUNDED_1950);

        // then
        assertEquals(2, teamListDto.getTeams().size());
    }
}
