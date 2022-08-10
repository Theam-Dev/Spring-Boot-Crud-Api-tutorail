package com.example.dev.service;

import com.example.dev.model.Post;

public interface PostService {
	Iterable<Post> getAll();
    Post saveData(Post post);
    Post getById(Long id);
    String deleteById(Long id);
}
