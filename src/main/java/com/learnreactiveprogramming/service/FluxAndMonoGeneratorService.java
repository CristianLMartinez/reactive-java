package com.learnreactiveprogramming.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class FluxAndMonoGeneratorService {

    private final static Logger logger = LoggerFactory.getLogger(FluxAndMonoGeneratorService.class);

    public Flux<String> namesFlux(){
        return  Flux.fromIterable(List.of("Alex", "Ben", "Chloe"));
    }

    public Mono<String> namesMono(){
        return  Mono.just("Alex");
    }

    public static void main(String[] args) {
        var fluxAndMono = new FluxAndMonoGeneratorService();
        logger.debug(" == starting flux operation == ");
        fluxAndMono.namesFlux()
                .subscribe(item -> System.out.println("Item is: " + item));
        logger.debug(" == ending flux operation == ");

        logger.debug(" == starting mono operation == ");
        fluxAndMono.namesMono()
                .subscribe(item -> System.out.println("Item is: " + item));
        logger.debug(" == ending mono operation == ");

    }


}
