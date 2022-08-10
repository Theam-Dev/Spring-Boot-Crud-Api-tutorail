package com.example.dev.serviceImp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dev.model.Post;
import com.example.dev.repository.PostRepository;
import com.example.dev.service.PostService;

@Service
public class PostServiceImp implements PostService{
	@Autowired
	private PostRepository repo;

	@Override
	public Iterable<Post> getAll() {
		return repo.findAll();
	}
	@Override
	public Post getById(Long id) {
		 Optional<Post> optional = repo.findById(id);
	        Post post = null;
	        if (optional.isPresent()) {
	            post = optional.get();
	        } else {
	            throw new RuntimeException(" found for id :: " + id);
	        }
	        return post;
	}
	@Override
	public String deleteById(Long id) {
		this.repo.deleteById(id);
		Optional<Post> optional = null;
		
		optional = repo.findById(id);
        if (!optional.isPresent()) {
            return "Data Not Found";
        }
        repo.deleteById(id);
        return "Success deleted!";
		
	}
	@Override
	public Post saveData(Post post) {
		return this.repo.save(post);
	}

}
