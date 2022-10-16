package com.example.pokedex.services.interfaces;

import com.example.pokedex.controllers.dtos.response.PokemonResponse;
import com.example.pokedex.controllers.dtos.response.SkillResponse;
import com.example.pokedex.entities.Projections.PokemonProjections;

import java.util.List;

public interface IPokemonSkillService {
    List<SkillResponse> listAllSkillsByPokemonId(Long pokemonId);
    List<PokemonResponse> listAllPokemonBySkillsId(Long skillId);
}
