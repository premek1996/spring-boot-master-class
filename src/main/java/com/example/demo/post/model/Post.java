package com.example.demo.post.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@ToString
@Getter
public class Post {

    private final Long userId;
    private final Long id;
    private final String title;
    private final String body;

}
