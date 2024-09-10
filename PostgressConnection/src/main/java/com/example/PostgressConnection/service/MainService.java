package com.example.PostgressConnection.service;

import com.example.PostgressConnection.model.User;
import com.example.PostgressConnection.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MainService {

    @Autowired
    UserRepository urepo;

    public User addUser(User user1) {
        return urepo.save(user1);
    }


    public String validateUser(User user1) {
        Optional<User> optional= urepo.findByuserName(user1.getUserName());
        if(optional.isPresent())
        {
            User dbUser=optional.get();
            if(dbUser.getPassword().equals(user1.getPassword())){
                return "Correct ";
            }
            else{
                return "Wrong Password";
            }
        }

        return "Incorrect UserName and Password";
    }
}
