package com.daviddefco.codesamples.spring5.springmvcrest.api.v1.mapper;

import com.daviddefco.codesamples.spring5.springmvcrest.api.v1.model.TeamDto;
import com.daviddefco.codesamples.spring5.springmvcrest.domain.Team;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TeamMapperTests {

    public static final String TEAM_NAME = "Los Angeles Lakers";
    public static final String ARENA = "Staples Center";
    public static final int FOUNDATION = 1949;

    @Test
    public void teamMappingTest() {

        // given
        Team lal = new Team();
        lal.setName(TEAM_NAME);
        lal.setArena(ARENA);
        lal.setFounded(FOUNDATION);

        // when
        TeamDto lalDto = TeamMapper.INSTANCE.teamToTeamDto(lal);

        // then
        assertEquals(TEAM_NAME, lalDto.getName());
        assertEquals(ARENA, lalDto.getPlaysAt());
        assertEquals(FOUNDATION, lal.getFounded());
    }
}
