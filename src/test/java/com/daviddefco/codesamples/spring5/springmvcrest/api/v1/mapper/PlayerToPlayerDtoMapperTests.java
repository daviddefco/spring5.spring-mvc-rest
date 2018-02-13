package com.daviddefco.codesamples.spring5.springmvcrest.api.v1.mapper;

import com.daviddefco.codesamples.spring5.springmvcrest.api.v1.mapper.PlayerMapper;
import com.daviddefco.codesamples.spring5.springmvcrest.api.v1.model.PlayerDto;
import com.daviddefco.codesamples.spring5.springmvcrest.domain.Player;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

public class PlayerToPlayerDtoMapperTests {

    public static final String PLAYER_NAME = "Brandom Ingram";

    @Test
    public void playerConversionIsOK() {
        // given
        Player ingram = new Player();
        ingram.setName(PLAYER_NAME);

        // when
        PlayerDto playerDto = PlayerMapper.INSTANCE.playerToPlayerDto(ingram);
        
        //then
        assertNotNull(playerDto);
        assertEquals(playerDto.getName(), "Brandom Ingram");
    }
}
