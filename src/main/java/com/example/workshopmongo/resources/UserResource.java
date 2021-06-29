package com.example.workshopmongo.resources;

import com.example.workshopmongo.domain.User;
import com.example.workshopmongo.dto.UserDTO;
import com.example.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.websocket.server.PathParam;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        List<User> list = service.findAll();
        List<UserDTO> dtoList = list
                .stream()
                .map(obj -> new UserDTO((obj)))
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtoList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable("id") String id){
        User user = service.findById(id);
        return ResponseEntity.ok(new UserDTO(user));
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody UserDTO body){

        User user = service.fromDTO(body);
        user = service.insert(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
