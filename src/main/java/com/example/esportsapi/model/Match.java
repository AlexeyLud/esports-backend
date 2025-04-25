package com.example.esportsapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Match implements Serializable {
    @JsonProperty("id")
    private String id;
    @JsonProperty("tournament_id")
    private String tournamentId;
    @JsonProperty("tournament_name")
    private String tournament_name;
    @JsonProperty("status_type")
    private String status;
    @JsonProperty("start_time")
    private String startTime;
    @JsonProperty("home_team_name")
    private String home_team;
    @JsonProperty("home_team_hash_image")
    private String home_team_hash_image;
    private int home_team_score;
    @JsonProperty("away_team_name")
    private String away_team;
    @JsonProperty("away_team_hash_image")
    private String away_team_hash_image;
    private int away_team_score;
    @JsonProperty("class_name")
    private String game;
    @JsonProperty("league_name")
    private String league;

    @JsonProperty("home_team_score")
    private void unpackHomeScore(Object statusObj) {
        if (statusObj instanceof java.util.Map) {
            this.home_team_score = (int) ((java.util.Map<?, ?>) statusObj).get("current");
        } else if (statusObj instanceof String) {
            this.home_team_score = (int) statusObj;
        }
    }

    @JsonProperty("away_team_score")
    private void unpackAwayScore(Object statusObj) {
        if (statusObj instanceof java.util.Map) {
            this.away_team_score = (int) ((java.util.Map<?, ?>) statusObj).get("current");
        } else if (statusObj instanceof String) {
            this.away_team_score = (int) statusObj;
        }
    }

    public String getId() {
        return id;
    }

    public String getTournamentId() {
        return tournamentId;
    }

    public String getStatus() {
        return status;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getHome_team() {
        return home_team;
    }

    public String getAway_team() {
        return away_team;
    }

    public String getTournament_name() {
        return tournament_name;
    }

    public String getHome_team_hash_image() {
        return home_team_hash_image;
    }

    public int getHome_team_score() {
        return home_team_score;
    }

    public String getAway_team_hash_image() {
        return away_team_hash_image;
    }

    public int getAway_team_score() {
        return away_team_score;
    }

    public String getGame() {
        return game;
    }

    public String getLeague() {
        return league;
    }
}
