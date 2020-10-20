package com.redhat.demo;

import io.quarkus.mongodb.panache.PanacheMongoEntity;

public class Fruit extends PanacheMongoEntity {

    public String name;
    public String description;
    public String season;

    public String getName() {
        return name.toUpperCase();
    }

    public void setName(String name) {
        this.name = name.toLowerCase();
    }

    public String getDescription() {
        return description.toUpperCase();
    }

    public void setDescription(String description) {
        this.description = description.toLowerCase();
    }

    public String getSeason() {
        return season.toUpperCase();
    }

    public void setSeason(String season) {
        this.season = season.toLowerCase();
    }
}
