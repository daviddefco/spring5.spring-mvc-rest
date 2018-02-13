package com.daviddefco.codesamples.spring5.springmvcrest.services;

import com.daviddefco.codesamples.spring5.springmvcrest.api.v1.model.PlayerDto;
import com.daviddefco.codesamples.spring5.springmvcrest.api.v1.model.PlayerListDto;
import com.daviddefco.codesamples.spring5.springmvcrest.domain.Player;
import com.daviddefco.codesamples.spring5.springmvcrest.domain.Team;
import com.daviddefco.codesamples.spring5.springmvcrest.repositories.PlayerRepository;
import com.daviddefco.codesamples.spring5.springmvcrest.repositories.TeamRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.swing.*;

import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class PlayerServiceIT {

    public static final String LARRY_NANCE_JR = "Larry Nance Jr";
    @Autowired
    PlayerService playerService;

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    TeamRepository teamRepository;

    @Test
    public void getAllPlayersOnLakersTeam() throws Exception {

        // when
        PlayerListDto lakersPlayers = playerService.findPlayersFromTeam(1L);

        // then
        assertEquals(4, lakersPlayers.getPlayers().size());
    }

    @Test
    public void newPlayerIsSaved() {

        // given
        PlayerDto nance = new PlayerDto();
        nance.setName(LARRY_NANCE_JR);
        nance.setPlaysFor(teamRepository.findById(3L).get());
        long currentPlayers = playerRepository.count();

        // when
        PlayerDto nanceDto = playerService.savePlayer(nance);

        // then
        assertEquals(currentPlayers +1, playerRepository.count());
        assertEquals(LARRY_NANCE_JR, nanceDto.getName());
    }

    @Test
    public void playerIsUpdated() {

        // given
        PlayerDto ingram = playerService.findPlayerByName("Brandom Ingram");
        ingram.setJerseyNumber(14);

        // when
        PlayerDto updatedPlayer = playerService.updatePlayer(ingram);

        // then
        assertEquals(14, updatedPlayer.getJerseyNumber().intValue());

    }

    @Test
    public void playerIsDeleted() {

        // given
        long numberOfPlayers = playerRepository.count();

        // when
        playerService.deletePlayer(1L);

        // then
        assertEquals(numberOfPlayers -1, playerRepository.count());

    }
}
