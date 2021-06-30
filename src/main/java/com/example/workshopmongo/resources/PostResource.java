package com.example.workshopmongo.resources;

import com.example.workshopmongo.domain.Post;
import com.example.workshopmongo.resources.utils.URLDecode;
import com.example.workshopmongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

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


        @GetMapping(value = "/all-search")
    public ResponseEntity<List<Post>> allSearch(@RequestParam(value = "text", defaultValue = "") String text,
                                                @RequestParam(value = "minDate", defaultValue = "") String minDate,
                                                @RequestParam(value = "maxDate", defaultValue = "") String maxDate){

        text = URLDecode.decodeParam(text);
        Date min = URLDecode.convertDate(minDate, new Date(0L));
        Date max = URLDecode.convertDate(maxDate, new Date(0L));

        List<Post> post = service.findAllAndBetweenDates(text,min,max);
        return ResponseEntity.ok(post);
    }





}
