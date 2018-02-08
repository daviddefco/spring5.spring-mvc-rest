package com.daviddefco.codesamples.spring5.springmvcrest.bootstrap;

import com.daviddefco.codesamples.spring5.springmvcrest.domain.Player;
import com.daviddefco.codesamples.spring5.springmvcrest.domain.Team;
import com.daviddefco.codesamples.spring5.springmvcrest.repositories.PlayerRepository;
import com.daviddefco.codesamples.spring5.springmvcrest.repositories.TeamRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Bootstrap implements CommandLineRunner {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public void run(String... args) throws Exception {
        Team lal = new Team();
        lal.setName("Los Angeles Lakers");

        Team lac = new Team();
        lac.setName("Los Angeles Clippers");

        Player williams = new Player();
        williams.setName("Lou Williams");
        williams.setPlaysFor(lac);

        Player ingram = new Player();
        ingram.setName("Brandom Ingram");
        ingram.setPlaysFor(lal);

        Player kuzma = new Player();
        kuzma.setName("Kyle Kuzma");
        kuzma.setPlaysFor(lal);

        Player ball = new Player();
        ball.setName("Lonzo Ball");
        ball.setPlaysFor(lal);

        Player hart = new Player();
        hart.setName("Josh Hart");
        hart.setPlaysFor(lal);

        teamRepository.save(lal);
        teamRepository.save(lac);
        log.info(String.format("Loaded %d teams", teamRepository.count()));

        playerRepository.save(ingram);
        playerRepository.save(kuzma);
        playerRepository.save(ball);
        playerRepository.save(hart);
        playerRepository.save(williams);
        log.info(String.format("Loaded %d players", playerRepository.count()));
    }

}
