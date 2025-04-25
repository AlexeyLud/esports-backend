package com.example.esportsapi.service;

import com.example.esportsapi.model.Game;
import com.example.esportsapi.model.Match;
import com.example.esportsapi.model.Team;
import com.example.esportsapi.model.Tournament;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Service
public class EsportsService {

    private static final Logger logger = LoggerFactory.getLogger(EsportsService.class);
    private final RestTemplate restTemplate;

    @Value("${esports.api.base-url}")
    private String baseUrl;

    @Value("${esports.api.key}")
    private String apiKey;

    public EsportsService() {
        this.restTemplate = new RestTemplate();
    }

    @Cacheable(value = "games")
    public List<Game> getAllGames() {
        logger.info("Fetching all games from API");
        URI uri = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .path("/classes")
                .build()
                .toUri();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);

        RequestEntity<Void> requestEntity = new RequestEntity<>(headers, HttpMethod.GET, uri);
        ResponseEntity<List<Game>> response = restTemplate.exchange(
                requestEntity,
                new ParameterizedTypeReference<List<Game>>() {}
        );

        return response.getBody();
    }

    @Cacheable(value = "game", key = "#gameId")
    public Game getGameById(String gameId) {
        logger.info("Fetching game with ID: {}", gameId);
        URI uri = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .path("/classes")
                .queryParam("id", "eq." + gameId)
                .buildAndExpand(gameId)
                .toUri();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);

        RequestEntity<Void> requestEntity = new RequestEntity<>(headers, HttpMethod.GET, uri);
        ResponseEntity<List<Game>> response = restTemplate.exchange(
                requestEntity,
                new ParameterizedTypeReference<List<Game>>() {}
        );

        return response.getBody().get(0);
    }

    @Cacheable(value = "tournaments")
    public List<Tournament> getAllTournaments() {
        logger.info("Fetching all tournaments from API");
        URI uri = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .path("/tournaments")
                .build()
                .toUri();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);

        RequestEntity<Void> requestEntity = new RequestEntity<>(headers, HttpMethod.GET, uri);
        ResponseEntity<List<Tournament>> response = restTemplate.exchange(
                requestEntity,
                new ParameterizedTypeReference<List<Tournament>>() {}
        );

        return response.getBody();
    }

    @Cacheable(value = "tournament", key = "#tournamentId")
    public Tournament getTournamentById(String tournamentId) {
        logger.info("Fetching tournament with ID: {}", tournamentId);
        URI uri = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .path("/tournaments")
                .queryParam("id", "eq." + tournamentId)
                .buildAndExpand(tournamentId)
                .toUri();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);

        RequestEntity<Void> requestEntity = new RequestEntity<>(headers, HttpMethod.GET, uri);
        ResponseEntity<List<Tournament>> response = restTemplate.exchange(
                requestEntity,
                new ParameterizedTypeReference<List<Tournament>>() {}
        );

        return response.getBody().get(0);
    }

    @Cacheable(value = "teams")
    public List<Team> getAllTeams() {
        logger.info("Fetching all teams from API");
        URI uri = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .path("/teams")
                .build()
                .toUri();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);

        RequestEntity<Void> requestEntity = new RequestEntity<>(headers, HttpMethod.GET, uri);
        ResponseEntity<List<Team>> response = restTemplate.exchange(
                requestEntity,
                new ParameterizedTypeReference<List<Team>>() {}
        );

        return response.getBody();
    }

    @Cacheable(value = "team", key = "#teamId")
    public Team getTeamById(String teamId) {
        logger.info("Fetching team with ID: {}", teamId);
        URI uri = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .path("/teams")
                .queryParam("id", "eq." + teamId)
                .buildAndExpand(teamId)
                .toUri();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);

        RequestEntity<Void> requestEntity = new RequestEntity<>(headers, HttpMethod.GET, uri);
        ResponseEntity<List<Team>> response = restTemplate.exchange(
                requestEntity,
                new ParameterizedTypeReference<List<Team>>() {}
        );

        return response.getBody().get(0);
    }

    @Cacheable(value = "matches")
    public List<Match> getMatches() {
        logger.info("Fetching all matches from API");
        URI uri = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .path("/matches")
                .build()
                .toUri();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);

        RequestEntity<Void> requestEntity = new RequestEntity<>(headers, HttpMethod.GET, uri);
        ResponseEntity<List<Match>> response = restTemplate.exchange(
                requestEntity,
                new ParameterizedTypeReference<List<Match>>() {}
        );

        logger.info("Body: {}", response.getBody());

        return response.getBody();
    }

    @Cacheable(value = "matchesByTournament", key = "#tournamentId")
    public List<Match> getMatchesByTournament(String tournamentId) {
        logger.info("Fetching matches for tournament ID: {}", tournamentId);
        URI uri = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .path("/matches")
                .queryParam("tournament_id", "eq." + tournamentId)
                .buildAndExpand(tournamentId)
                .toUri();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);

        RequestEntity<Void> requestEntity = new RequestEntity<>(headers, HttpMethod.GET, uri);
        ResponseEntity<List<Match>> response = restTemplate.exchange(
                requestEntity,
                new ParameterizedTypeReference<List<Match>>() {}
        );

        return response.getBody();
    }

    @Cacheable(value = "match", key = "#matchId")
    public Match getMatchById(String matchId) {
        logger.info("Fetching match with ID: {}", matchId);
        URI uri = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .path("/matches")
                .queryParam("id", "eq." + matchId)
                .buildAndExpand(matchId)
                .toUri();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);

        RequestEntity<Void> requestEntity = new RequestEntity<>(headers, HttpMethod.GET, uri);
        ResponseEntity<List<Match>> response = restTemplate.exchange(
                requestEntity,
                new ParameterizedTypeReference<List<Match>>() {}
        );

        logger.info("Body1: {}", response.getBody());

        return response.getBody().get(0);
    }

}