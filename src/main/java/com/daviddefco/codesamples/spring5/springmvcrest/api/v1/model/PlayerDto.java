package com.daviddefco.codesamples.spring5.springmvcrest.api.v1.model;

import com.daviddefco.codesamples.spring5.springmvcrest.domain.Team;
import lombok.Data;

@Data
public class PlayerDto {
    private Long id;
    private String name;
    private Integer jerseyNumber;
    private String positionPlayed;
    private Integer priorExperience;
    private Integer weight;
    private String height;
    private Team playsFor;
}
