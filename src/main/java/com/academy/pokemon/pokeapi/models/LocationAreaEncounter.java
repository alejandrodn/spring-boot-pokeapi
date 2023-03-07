package com.academy.pokemon.pokeapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LocationAreaEncounter {
    @JsonProperty("location_area")
    private LocationArea locationAreaEncounter;

    public LocationArea getLocationAreaEncounter() {
        return this.locationAreaEncounter;
    }
}
