package co.com.sofka.integer_generator.controllers;

import co.com.sofka.integer_generator.dtos.RandomIntegerDTO;
import co.com.sofka.integer_generator.models.RandomInteger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class RandomIntegerControllerTest {
    @Autowired
    RandomIntegerController controller;
    @Test
    void testCreateRandomList() {

        Mono<RandomInteger> list = controller.forNumber(new RandomIntegerDTO(1,2));

        StepVerifier.create(list)
                .expectNextMatches(
                        element -> {
                            if(element.getOrginalList().equals("1,2") &&
                                    element.getDate().toString().equals((new Date().toString())) &&
                                    (element.getRandomList().equals("1,2") || element.getRandomList().equals("2,1"))){
                                return true;
                            }
                            return false;
                        }
                ).verifyComplete();
    }
}