package com.myprojects.pokeapiwmysql.config;

import com.myprojects.pokeapiwmysql.model.Pokemon;
import com.myprojects.pokeapiwmysql.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private PokemonRepository pokemonRepository;

    @Override
    public void run(String... args) {
        if (pokemonRepository.count() == 0) {
            initializePokemons();
        }
    }

    private void initializePokemons() {
        pokemonRepository.save(new Pokemon(null, "Pikachu", "Electric", 25, 35, 55, 40));
        pokemonRepository.save(new Pokemon(null, "Charmander", "Fire", 10, 39, 52, 43));
        pokemonRepository.save(new Pokemon(null, "Squirtle", "Water", 8, 44, 48, 65));
        pokemonRepository.save(new Pokemon(null, "Bulbasaur", "Grass", 12, 45, 49, 49));
        pokemonRepository.save(new Pokemon(null, "Jigglypuff", "Normal", 15, 115, 45, 20));
    }
}