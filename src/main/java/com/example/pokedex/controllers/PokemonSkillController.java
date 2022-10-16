package com.example.pokedex.controllers;

import com.example.pokedex.controllers.dtos.response.PokemonResponse;
import com.example.pokedex.controllers.dtos.response.SkillResponse;
import com.example.pokedex.services.PokemonSkillServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("pokemon-skill")
public class PokemonSkillController {
    @Autowired
    private PokemonSkillServiceImpl service;

    @GetMapping("pokemon/skill/{pokemonId}")
    public List<SkillResponse> listAllSkillsByPokemonId(@PathVariable Long pokemonId){
        return service.listAllSkillsByPokemonId(pokemonId);
    }

    @GetMapping("skill/pokemon/{skillId}")
    public List<PokemonResponse> listAllPokemonBySkillsId(@PathVariable Long skillId){
        return service.listAllPokemonBySkillsId(skillId);
    }
}
