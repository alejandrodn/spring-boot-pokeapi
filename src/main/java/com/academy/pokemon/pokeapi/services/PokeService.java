package com.academy.pokemon.pokeapi.services;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import com.academy.pokemon.pokeapi.models.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
@Service
@RequiredArgsConstructor
public class PokeService {

    private String baseUrl = "https://pokeapi.co/api/v2/pokemon/";
    // private String encountersUrl = "https://pokeapi.co/api/v2/pokemon/12/encounters";

    private final RestTemplate restTemplate;
    
    public List<AbilityItem> getAbilities(String name) {
        HttpHeaders headers = new HttpHeaders();

        headers.add("user-agent", "Application");
        headers.add("Content-Type", "application/json");

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Pokemon> response = restTemplate.exchange(baseUrl + name, HttpMethod.GET, entity, Pokemon.class);       
        return response.getBody().getAbilityItems();
    }
    public List<HeldItem> getHeldItems(String name) {
        HttpHeaders headers = new HttpHeaders();

        headers.add("user-agent", "Application");
        headers.add("Content-Type", "application/json");

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Pokemon> response = restTemplate.exchange(baseUrl + name, HttpMethod.GET, entity, Pokemon.class);       
        return response.getBody().getHeldItems();
    }

    public List<LocationAreaEncounter> getLocationAreaEncounters(String name) {
        HttpHeaders headers = new HttpHeaders();

        headers.add("user-agent", "Application");
        headers.add("Content-Type", "application/json");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<Pokemon> pokemonResponse = restTemplate.exchange(baseUrl + name, HttpMethod.GET, entity, Pokemon.class);
        Integer pokemonId = pokemonResponse.getBody().getId();

        String url = baseUrl + pokemonId + "/encounters/";

        ResponseEntity<LocationAreaEncounter[]> response = restTemplate.exchange(url, HttpMethod.GET, entity, LocationAreaEncounter[].class);       
        return Arrays.asList(response.getBody());
    }

    public Integer getId(String name) {
        HttpHeaders headers = new HttpHeaders();

        headers.add("user-agent", "Application");
        headers.add("Content-Type", "application/json");

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Pokemon> response = restTemplate.exchange(baseUrl + name, HttpMethod.GET, entity, Pokemon.class);
        return response.getBody().getId();
    }

    public String getName(String name) {
        HttpHeaders headers = new HttpHeaders();

        headers.add("user-agent", "Application");
        headers.add("Content-Type", "application/json");

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Pokemon> response = restTemplate.exchange(baseUrl + name, HttpMethod.GET, entity, Pokemon.class);
        return response.getBody().getName();
    }

    public Integer getBaseExperience(String name) {
        HttpHeaders headers = new HttpHeaders();

        headers.add("user-agent", "Application");
        headers.add("Content-Type", "application/json");

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Pokemon> response = restTemplate.exchange(baseUrl + name, HttpMethod.GET, entity, Pokemon.class);
        return response.getBody().getBaseExperience();
    }
}
