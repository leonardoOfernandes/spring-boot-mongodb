package com.example.workshopmongo.repository;

import com.example.workshopmongo.domain.Post;
import com.example.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
