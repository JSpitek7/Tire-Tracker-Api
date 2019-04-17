package app.models;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class TruckTypeDto {
    private Integer id;
    private String name;

    public TruckTypeDto(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
