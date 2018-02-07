package com.daviddefco.codesamples.spring5.springmvcrest.api.v1.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PlayerListDto {
    private List<PlayerDto> players;
}
