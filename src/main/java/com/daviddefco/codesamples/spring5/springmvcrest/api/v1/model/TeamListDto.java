package com.daviddefco.codesamples.spring5.springmvcrest.api.v1.model;

import com.daviddefco.codesamples.spring5.springmvcrest.domain.Team;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class TeamListDto {
    private List<TeamDto> teams;
}
