package com.example.demo.post.controller;

import com.example.demo.post.client.JSONPlaceHolderClient;
import com.example.demo.post.model.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("${posts-api-v1-uri}")
@RequiredArgsConstructor
public class PostController {

    private final JSONPlaceHolderClient jsonPlaceHolderClient;

    @GetMapping
    List<Post> getPosts() {
        return jsonPlaceHolderClient.getPosts();
    }

    @GetMapping("{id}")
    Post getPostBydId(@PathVariable Long id) {
        return jsonPlaceHolderClient.getPostBydId(id);
    }

}
