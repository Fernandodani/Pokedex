package com.example.pokedex.controllers;

import com.example.pokedex.controllers.dtos.request.CreateCommentRequest;
import com.example.pokedex.controllers.dtos.request.UpdateCommentRequest;
import com.example.pokedex.controllers.dtos.response.*;
import com.example.pokedex.services.interfaces.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("comment")
public class CommentController {
    @Autowired
    private ICommentService service;

    @GetMapping("{id}")
    public GetCommentResponse get(@PathVariable Long id){
        return service.get(id);
    }

    @PostMapping
    public CreateCommentResponse Create(@RequestBody CreateCommentRequest request){
        return service.create(request);
    }

    @PutMapping("{id}")
    public UpdateCommentResponse update(@RequestBody UpdateCommentRequest request, @PathVariable Long id){
        return service.update(request, id);
    }

    @GetMapping
    public List<GetCommentResponse> list(){
        return service.list();
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

}
