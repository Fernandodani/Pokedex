package com.example.pokedex.controllers.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateForumRequest {
    private String topic;

    private String date;

    private String hour;

}
