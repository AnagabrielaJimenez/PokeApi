package com.myprojects.pokeapiwmysql.service;

import com.myprojects.pokeapiwmysql.model.Pokemon;
import com.myprojects.pokeapiwmysql.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PokemonService {

    @Autowired
    private PokemonRepository pokemonRepository;

    public List<Pokemon> getAllPokemons() {
        return pokemonRepository.findAll();
    }

    public Optional<Pokemon> getPokemonById(Long id) {
        return pokemonRepository.findById(id);
    }

    public Pokemon createPokemon(Pokemon pokemon) {
        return pokemonRepository.save(pokemon);
    }

    public Pokemon updatePokemon(Long id, Pokemon pokemonDetails) {
        Pokemon pokemon = pokemonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pokemon not found with id " + id));

        pokemon.setName(pokemonDetails.getName());
        pokemon.setType(pokemonDetails.getType());
        pokemon.setLevel(pokemonDetails.getLevel());
        pokemon.setHp(pokemonDetails.getHp());
        pokemon.setAttack(pokemonDetails.getAttack());
        pokemon.setDefense(pokemonDetails.getDefense());

        return pokemonRepository.save(pokemon);
    }

    public void deletePokemon(Long id) {
        pokemonRepository.deleteById(id);
    }
}