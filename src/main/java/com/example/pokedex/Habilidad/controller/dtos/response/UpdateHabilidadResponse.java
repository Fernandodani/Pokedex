package com.example.pokedex.Habilidad.controller.dtos.response;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UpdateHabilidadResponse {
    private Long id;
    private String nombre;
    private String efecto;
    private String tipo;
}