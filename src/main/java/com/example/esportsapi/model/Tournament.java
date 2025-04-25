package com.example.esportsapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tournament implements Serializable {
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("league_name")
    private String league_name;
    @JsonProperty("league_hash_image")
    private String league_hash_image;
    @JsonProperty("class_name")
    private String game;
    @JsonProperty("class_hash_image")
    private String class_hash_image;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLeague_name() {
        return league_name;
    }

    public String getLeague_hash_image() {
        return league_hash_image;
    }

    public String getGame() {
        return game;
    }

    public String getClass_hash_image() {
        return class_hash_image;
    }
}
