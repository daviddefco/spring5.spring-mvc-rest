package com.daviddefco.codesamples.spring5.springmvcrest.repositories;

import com.daviddefco.codesamples.spring5.springmvcrest.domain.Player;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<Player, Long>{
    Player findByName(String playerName);
}
