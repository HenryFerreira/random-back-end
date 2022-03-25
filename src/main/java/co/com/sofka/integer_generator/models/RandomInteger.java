package co.com.sofka.integer_generator.models;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class RandomInteger {
    @Id
    private String id;
    private Date date;
    private Integer randomList;

    public RandomInteger() {
    }

    public RandomInteger(String id, Date date, Integer randomList) {
        this.id = id;
        this.date = date;
        this.randomList = randomList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getRandomList() {
        return randomList;
    }

    public void setRandomList(Integer randomList) {
        this.randomList = randomList;
    }
}
