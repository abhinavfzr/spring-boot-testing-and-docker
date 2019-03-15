package com.stackroute.userservice.seed;

import com.stackroute.userservice.domain.Restaurent;
import com.stackroute.userservice.repository.RestaurentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineListenerSeed implements CommandLineRunner {

    private RestaurentRepository restaurentRepository;


    public CommandLineListenerSeed(RestaurentRepository restaurentRepository) {
        this.restaurentRepository = restaurentRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Restaurent restaurent = new Restaurent( "dhaba", "image", "kormangala");
        restaurentRepository.save(restaurent);
    }
}
