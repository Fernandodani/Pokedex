package com.example.pokedex.controllers.dtos.response;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateHabilidadResponse {
    private Long id;
    private String nombre;
    private String efecto;
    private String tipo;
}