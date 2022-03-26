package co.com.sofka.integer_generator.repositories;

import co.com.sofka.integer_generator.models.RandomInteger;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface RandomIntegerRepository extends ReactiveCrudRepository<RandomInteger, String> {
}
