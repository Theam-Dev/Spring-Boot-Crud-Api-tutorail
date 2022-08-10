package com.example.dev.controller;

import org.springframework.http.HttpHeaders;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.dev.helper.ResponseHandler;
import com.example.dev.model.Post;
import com.example.dev.service.PostService;

@RestController
@RequestMapping("/api")
public class PostController {
	@Autowired
	PostService service;
	
    public PostController(PostService service) {
		super();
		this.service = service;
	}
    @GetMapping(value = "/post")
    public ResponseEntity<Object> Get() {
        try {
            Iterable<Post> result = service.getAll();
            return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, result);	
        } catch (Exception e) {
            return ResponseHandler.generateResponse("Data Not found", HttpStatus.MULTI_STATUS, null);
        }
    }
 
    @GetMapping({"/post/{id}"})
    public ResponseEntity<Object> getId(@PathVariable Long id) {
    	try {
			Post post = service.getById(id);
			return ResponseHandler.generateResponse("Data Inserted", HttpStatus.OK, post);
		} catch (Exception e) {
			return ResponseHandler.generateResponse("Data can not insert", HttpStatus.MULTI_STATUS, null);
		}
    }
    @PostMapping("/post")
    public ResponseEntity<Object> savePost(@RequestBody Post post) {
    	try {
			Post data = service.saveData(post);
			return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, data);
		} catch (Exception e) {
			return ResponseHandler.generateResponse("Data Not found", HttpStatus.MULTI_STATUS, null);
		}
    }

    @DeleteMapping({"/post/{id}"})
    public ResponseEntity<Object> deletePost(@PathVariable("id") Long id) {
    	try {
			service.deleteById(id);
			return ResponseHandler.generateResponse("Data Deleted !!", HttpStatus.OK,null);
		} catch (Exception e) {
			return ResponseHandler.generateResponse("Data Not found", HttpStatus.MULTI_STATUS, null);
		}
    }
}
