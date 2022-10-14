package com.example.pokedex.services;

import com.example.pokedex.controllers.dtos.request.CreatePokebolaRequest;
import com.example.pokedex.controllers.dtos.request.UpdatePokebolaRequest;
import com.example.pokedex.controllers.dtos.response.CreatePokebolaResponse;
import com.example.pokedex.controllers.dtos.response.GetPokebolaResponse;
import com.example.pokedex.controllers.dtos.response.UpdatePokebolaResponse;
import com.example.pokedex.entities.Pokebola;
import com.example.pokedex.repositories.IPokebolaRepository;
import com.example.pokedex.services.interfaces.IPokebolaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServicePokebolaImpl implements IPokebolaService {
    @Autowired
    private IPokebolaRepository repository;


    @Override
    public GetPokebolaResponse get(Long id) {
        Pokebola pokebola = find(id);
        return from(pokebola);
    }

    @Override
    public CreatePokebolaResponse create(CreatePokebolaRequest request) {
        Pokebola pokebola = new Pokebola();
        pokebola.setNombre(request.getNombre());
        pokebola.setNivel(request.getNivel());
        pokebola.setColor(request.getColor());
        repository.save(pokebola);
        return to(pokebola);
    }


    @Override
    public UpdatePokebolaResponse update(UpdatePokebolaRequest request, Long id) {
        Pokebola pokebola = find(id);
        pokebola.setNombre(request.getNombre());
        pokebola.setNivel(request.getNivel());
        pokebola.setColor(request.getColor());
        repository.save(pokebola);
        return fromUpdate(pokebola);
    }

    @Override
    public List<GetPokebolaResponse> list() {
        return repository.findAll().stream().map(this::from).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    public GetPokebolaResponse from(Pokebola pokebola) {
        GetPokebolaResponse response = new GetPokebolaResponse();
        response.setId(pokebola.getId());
        response.setNombre(pokebola.getNombre());
        response.setNivel(pokebola.getNivel());
        response.setColor(pokebola.getColor());
        return response;
    }

    public CreatePokebolaResponse to(Pokebola pokebola) {
        CreatePokebolaResponse response = new CreatePokebolaResponse();
        response.setId(pokebola.getId());
        response.setNombre(pokebola.getNombre());
        response.setNivel(pokebola.getNivel());
        response.setColor(pokebola.getColor());
        return response;
    }

    public UpdatePokebolaResponse fromUpdate(Pokebola pokebola) {
        UpdatePokebolaResponse response = new UpdatePokebolaResponse();
        response.setId(pokebola.getId());
        response.setNombre(pokebola.getNombre());
        response.setNivel(pokebola.getNivel());
        response.setColor(pokebola.getColor());
        return response;
    }
    public Pokebola find(Long id){
        return  repository.findById(id).orElseThrow(()->new RuntimeException("no se encpontro"));
    }
}