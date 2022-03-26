package co.com.sofka.integer_generator.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import reactor.core.publisher.Flux;

import java.util.Date;
import java.util.List;

@Document
public class RandomInteger {
    private Date date;
    @Id
    private String id;

    private String orginalList;

    private String randomList;

    public String getRandomList() {
        return randomList;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setIde(String id) {
        this.id = id;
    }


    public String getOrginalList() {
        return orginalList;
    }

    public void setOrginalList(String orginalList) {
        this.orginalList = orginalList;
    }

    public void setRandomList(String randomList) {
        this.randomList = randomList;
    }
}
