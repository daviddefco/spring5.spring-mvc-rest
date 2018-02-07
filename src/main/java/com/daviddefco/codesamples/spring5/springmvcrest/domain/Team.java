package com.daviddefco.codesamples.spring5.springmvcrest.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Team {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;
    private String arena;
    private int founded;
}
