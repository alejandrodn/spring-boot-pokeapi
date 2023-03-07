package com.academy.pokemon.pokeapi.models;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Pokemon {
    private Integer id;
    private String name;
    @JsonProperty("base_experience")
    private Integer baseExperience;
    private List<AbilityItem> abilities;
    @JsonProperty("held_items")
    private List<HeldItem> heldItems;

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Integer getExperience() {
        return this.baseExperience;
    }

    public List<AbilityItem> getAbilityItems() {
        return this.abilities;
    }

    public List<HeldItem> getHeldItems() {
        return this.heldItems;
    }
}