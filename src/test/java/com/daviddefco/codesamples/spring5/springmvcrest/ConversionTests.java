package com.daviddefco.codesamples.spring5.springmvcrest;

import com.daviddefco.codesamples.spring5.springmvcrest.api.v1.mapper.PlayerMapper;
import com.daviddefco.codesamples.spring5.springmvcrest.api.v1.model.PlayerDto;
import com.daviddefco.codesamples.spring5.springmvcrest.domain.Player;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

public class ConversionTests {

    @Test
    public void playerConversionIsOK() {
        Player ingram = new Player();
        ingram.setName("Brandom Ingram");

        PlayerDto playerDto = PlayerMapper.INSTANCE.playerToPlayerDto(ingram);
        assertNotNull(playerDto);
        assertEquals(playerDto.getName(), "Brandom Ingram");
    }
}
