package com.redhat.demo;

import io.quarkus.mongodb.panache.PanacheMongoEntity;

import java.util.List;

public class Person extends PanacheMongoEntity {
    public String name;
    public String lastName;
    public String status;

    public static Person findByName(String name){
        return find("name", name).firstResult();
    }

    public static List<Person> findAlive(){
        return list("status", "alive");
    }

    public static void deleteLoics(){
        delete("name", "Loïc");
    }
}
