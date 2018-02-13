package com.daviddefco.codesamples.spring5.springmvcrest.api.v1.mapper;

import com.daviddefco.codesamples.spring5.springmvcrest.api.v1.model.PlayerDto;
import com.daviddefco.codesamples.spring5.springmvcrest.domain.Player;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerDtoToPlayerMapperTests {

    public static final String BRANDON_INGRAM = "Brandon Ingram";

    @Test
    public void playerDtoToPlayerTest() {

        // given
        PlayerDto ingramDto = new PlayerDto();
        ingramDto.setName(BRANDON_INGRAM);
        ingramDto.setPriorExperience(1);

        // when
        Player ingram = PlayerDtoMapper.INSTANCE.playerDtoToPlayer(ingramDto);

        // then
        assertEquals(BRANDON_INGRAM, ingram.getName());
        assertEquals(1, ingram.getExperience().longValue());
    }
}
