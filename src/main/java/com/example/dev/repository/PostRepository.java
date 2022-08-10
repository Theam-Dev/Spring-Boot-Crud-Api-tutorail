package com.example.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.dev.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
