package com.daviddefco.codesamples.spring5.springmvcrest.repositories;

import com.daviddefco.codesamples.spring5.springmvcrest.domain.Team;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TeamRepository extends CrudRepository<Team, Long> {
    List<Team> findByFoundedGreaterThan(Integer foundationYear);
}
