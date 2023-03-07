package com.academy.pokemon.pokeapi.controllers;
import java.util.List;
import com.academy.pokemon.pokeapi.services.PokeService;
import com.academy.pokemon.pokeapi.models.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pokemon")
@RequiredArgsConstructor
public class PokeController {

    private final PokeService pokeservice;

    @GetMapping("/{name}/abilities/")
    public List<AbilityItem> getAbilities(@PathVariable String name) {
        return pokeservice.getAbilities(name);
    }
    @GetMapping("/{name}/id/")
    public Integer getId(@PathVariable String name) {
        return pokeservice.getId(name);
    }
    @GetMapping("/{name}/name/")
    public String getName(@PathVariable String name) {
        return pokeservice.getName(name);
    }
    @GetMapping("/{name}/experience/")
    public Integer getBaseExperience(@PathVariable String name) {
        return pokeservice.getBaseExperience(name);
    }
    @GetMapping("/{name}/items/")
    public List<HeldItem> getHeldItems(@PathVariable String name) {
        return pokeservice.getHeldItems(name);
    }
    @GetMapping("/{name}/encounters/")
    public List<LocationAreaEncounter> getEncounters(@PathVariable String name) {
        return pokeservice.getLocationAreaEncounters(name);
    }

}
