package com.example.esportsapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Game implements Serializable {
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("hash_image")
    private String game_hash_image;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGame_hash_image() {
        return game_hash_image;
    }
}