package com.myprojects.pokeapiwmysql.repository;

import com.myprojects.pokeapiwmysql.model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
}