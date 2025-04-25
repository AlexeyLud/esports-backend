package com.example.esportsapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Team implements Serializable {
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("name_code")
    private String name_code;
    @JsonProperty("hash_image")
    private String team_hash_image;
    @JsonProperty("class_name")
    private String team_game;
    @JsonProperty("class_hash_image")
    private String game_hash_image;
    @JsonProperty("primary_league_name")
    private String pr_league_name;
    @JsonProperty("primary_league_hash_image")
    private String pr_league_hash_image;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getName_code() {
        return name_code;
    }

    public String getTeam_hash_image() {
        return team_hash_image;
    }

    public String getTeam_game() {
        return team_game;
    }

    public String getGame_hash_image() {
        return game_hash_image;
    }

    public String getPr_league_name() {
        return pr_league_name;
    }

    public String getPr_league_hash_image() {
        return pr_league_hash_image;
    }
}
