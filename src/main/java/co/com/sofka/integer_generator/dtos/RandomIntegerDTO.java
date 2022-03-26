package co.com.sofka.integer_generator.dtos;

import reactor.core.publisher.Flux;

import java.util.Date;
import java.util.List;

public class RandomIntegerDTO {
    private int number1;
    private int number2;

    public RandomIntegerDTO(int number1, int number2) {
        this.number1 = number1;
        this.number2 = number2;
    }

    public int getNumber1() {
        return number1;
    }

    public int getNumber2() {
        return number2;
    }

    public void setNumber2(int number2) {
        this.number2 = number2;
    }

    public void setNumber1(int number1) {
        this.number1 = number1;
    }

    @Override
    public String toString() {
        return "RandomIntegerDTO{" +
                "number1=" + number1 +
                ", number2=" + number2 +
                '}';
    }
}
