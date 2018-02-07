package com.daviddefco.codesamples.spring5.springmvcrest.api.v1.model;

import lombok.Data;

@Data
public class TeamDto {
    private Long id;
    private String name;
    private String playsAt;
    private int founded;
}
