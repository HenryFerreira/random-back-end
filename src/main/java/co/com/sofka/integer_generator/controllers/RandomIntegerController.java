package co.com.sofka.integer_generator.controllers;

import co.com.sofka.integer_generator.dtos.RandomIntegerDTO;
import co.com.sofka.integer_generator.models.RandomInteger;
import co.com.sofka.integer_generator.repositories.RandomIntegerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/random")
public class RandomIntegerController {
    private RandomIntegerRepository repository;

    @Autowired
    public RandomIntegerController(RandomIntegerRepository repository){
        this.repository = repository;
    }
    @PostMapping("")
    public Mono<RandomInteger> forNumber(@RequestBody RandomIntegerDTO request) {
        return Mono.just(new RandomInteger()).map(entity -> {
            entity.setDate(new Date());
            entity.setOrginalList(IntStream.range(request.getNumber1(), request.getNumber2()+1)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(",")));
            return entity;
        }).map(entity -> {
            var list = Stream.of(entity.getOrginalList().split(","))
                    .collect(Collectors.toList());
            Collections.shuffle(list);
            var randomList = list.stream().collect(Collectors.joining(","));
            entity.setRandomList(randomList);
            return entity;
        }).flatMap(repository::save);
    }

    @GetMapping("")
    public Flux<RandomInteger> get() {
        return repository.findAll();
    }

}
