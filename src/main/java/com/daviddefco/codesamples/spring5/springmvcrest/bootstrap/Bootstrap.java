package com.daviddefco.codesamples.spring5.springmvcrest.bootstrap;

import com.daviddefco.codesamples.spring5.springmvcrest.domain.Player;
import com.daviddefco.codesamples.spring5.springmvcrest.repositories.PlayerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Bootstrap implements CommandLineRunner {

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public void run(String... args) throws Exception {
        Player ingram = new Player();
        ingram.setName("Brandom Ingram");

        Player kuzma = new Player();
        kuzma.setName("Kyle Kuzma");

        Player ball = new Player();
        ball.setName("Lonzo Ball");

        Player hart = new Player();
        hart.setName("Josh Hart");

        playerRepository.save(ingram);
        playerRepository.save(kuzma);
        playerRepository.save(ball);
        playerRepository.save(hart);

        log.info(String.format("Loaded %d players", playerRepository.count()));
    }

}
