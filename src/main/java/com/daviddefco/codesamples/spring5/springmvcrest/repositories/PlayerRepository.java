package com.daviddefco.codesamples.spring5.springmvcrest.repositories;

import com.daviddefco.codesamples.spring5.springmvcrest.domain.Player;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PlayerRepository extends CrudRepository<Player, Long>{
    Optional<Player> findByName(String playerName);
}
