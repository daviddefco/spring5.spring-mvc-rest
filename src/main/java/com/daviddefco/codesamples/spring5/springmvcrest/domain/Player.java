package com.daviddefco.codesamples.spring5.springmvcrest.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Player {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String position;
    private Integer number;
    private Integer experience;
    private Integer weight;
    private String height;
    @ManyToOne
    private Team playsFor;
}
