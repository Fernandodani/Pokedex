package com.example.pokedex.controllers;

import com.example.pokedex.controllers.dtos.request.CreateHabilidadRequest;
import com.example.pokedex.controllers.dtos.request.UpdateHabilidadRequest;
import com.example.pokedex.controllers.dtos.response.CreateHabilidadResponse;
import com.example.pokedex.controllers.dtos.response.GetHabilidadResponse;
import com.example.pokedex.controllers.dtos.response.UpdateHabilidadResponse;
import com.example.pokedex.services.ServiceHabilidadImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Habilidad")
public class HabilidadController {
    @Autowired
    private ServiceHabilidadImpl service;
    @GetMapping("{id}")
    public GetHabilidadResponse get(@PathVariable Long id){
        return service.get(id);
    }

    @PostMapping
    public CreateHabilidadResponse Create(@RequestBody CreateHabilidadRequest request){
        return service.create(request);
    }

    @PutMapping("{id}")
    public UpdateHabilidadResponse update(@RequestBody UpdateHabilidadRequest request, @PathVariable Long id){
        return service.update(request, id);
    }

    @GetMapping
    public List<GetHabilidadResponse> list(){
        return service.list();
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}