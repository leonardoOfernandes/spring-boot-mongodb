package com.example.workshopmongo.services;

import com.example.workshopmongo.domain.User;
import com.example.workshopmongo.dto.UserDTO;
import com.example.workshopmongo.repository.UserRepository;
import com.example.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll(){
        return repo.findAll();
    }

    public User findById(String id){
        Optional<User> user = repo.findById(id);
        if(!user.isPresent()){
            throw  new ObjectNotFoundException("Objeto não encontrado");
        }

        return user.get();
    }

    public User insert(User obj){
        return repo.insert(obj);
    }

    public void delete(String id){
        Optional<User> user = repo.findById(id);
        if(!user.isPresent()){
            throw  new ObjectNotFoundException("Objeto não encontrado");
        }
        repo.deleteById(id);
    }

    public User update(User obj){
        Optional<User> user = repo.findById(obj.getId());
        if(!user.isPresent()){
            throw  new ObjectNotFoundException("Objeto não encontrado");
        }
        User newObj = user.get();
        updateData(newObj, obj);

        return repo.save(newObj);
    }

    private void updateData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }

    public User fromDTO(UserDTO userDTO){
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }
}
