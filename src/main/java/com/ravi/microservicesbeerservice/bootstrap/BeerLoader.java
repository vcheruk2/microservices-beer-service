package com.ravi.microservicesbeerservice.bootstrap;

import com.ravi.microservicesbeerservice.domain.Beer;
import com.ravi.microservicesbeerservice.repositories.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/* Created by: Venkata Ravichandra Cherukuri
   Created on: 5/28/2020 */
@Component
public class BeerLoader implements CommandLineRunner {

    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    private void loadBeer(){
        beerRepository.save(Beer.builder()
                    .beerName("Beer1")
                    .beerStyle("Style1")
                    .quantityToBrew(200)
                    .upc(1349103241L)
                    .price(new BigDecimal(9.99))
                    .build());

        beerRepository.save(Beer.builder()
                .beerName("Beer2")
                .beerStyle("Style2")
                .quantityToBrew(200)
                .upc(38230302934L)
                .price(new BigDecimal(7.99))
                .build());
    }

    @Override
    public void run(String... args) throws Exception {
        if (beerRepository.count() == 0)
            loadBeer();
    }
}
