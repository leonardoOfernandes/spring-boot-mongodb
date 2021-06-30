package com.example.workshopmongo.services;

import com.example.workshopmongo.domain.Post;
import com.example.workshopmongo.domain.User;
import com.example.workshopmongo.dto.UserDTO;
import com.example.workshopmongo.repository.PostRepository;
import com.example.workshopmongo.repository.UserRepository;
import com.example.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public List<Post> findAll(){
        return repo.findAll();
    }

    public Post findById(String id){
        Optional<Post> post = repo.findById(id);
        if(!post.isPresent()){
            throw  new ObjectNotFoundException("Objeto não encontrado");
        }

        return post.get();
    }

    public List<Post> findByTitle(String text){
        return repo.findByTitleContainingIgnoreCase(text);

    }

}
