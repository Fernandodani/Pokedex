package com.example.pokedex.controllers.dtos.response;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UpdateTrainerResponse {
    private Long id;

    private String name;

    private String age;

    private String nationality;
}
