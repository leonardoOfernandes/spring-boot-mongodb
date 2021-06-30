package com.example.workshopmongo.resources;

import com.example.workshopmongo.domain.Post;
import com.example.workshopmongo.domain.User;
import com.example.workshopmongo.dto.UserDTO;
import com.example.workshopmongo.resources.utils.URLDecode;
import com.example.workshopmongo.services.PostService;
import com.example.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.websocket.server.PathParam;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/post")
public class PostResource {

    @Autowired
    private PostService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable("id") String id){
        Post post = service.findById(id);
        return ResponseEntity.ok(post);
    }

    @GetMapping(value = "/title-search")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text){
        text = URLDecode.decodeParam(text);
        List<Post> post = service.findByTitle(text);
        return ResponseEntity.ok(post);
    }



}
