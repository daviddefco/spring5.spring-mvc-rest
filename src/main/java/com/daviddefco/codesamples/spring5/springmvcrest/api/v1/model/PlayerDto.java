package com.daviddefco.codesamples.spring5.springmvcrest.api.v1.model;

import com.daviddefco.codesamples.spring5.springmvcrest.domain.Team;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PlayerDto {
    private Long id;
    @ApiModelProperty(value = "The player's name", required = true)
    private String name;
    @ApiModelProperty(value = "The player's jersey number")
    private Integer jerseyNumber;
    @ApiModelProperty(value = "Position played: PG, SG, SF, PF or C")
    private String positionPlayed;
    @ApiModelProperty(value = "Years in the NBA (no High School exp is taken into account)")
    private Integer priorExperience;
    @ApiModelProperty(value = "Weight in lbs")
    private Integer weight;
    @ApiModelProperty(value = "Height in foots / inches")
    private String height;
    @ApiModelProperty(value = "The player's current team")
    private Team playsFor;
}
