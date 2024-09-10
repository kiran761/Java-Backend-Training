package com.example.PostgressConnection.repository;

import com.example.PostgressConnection.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository  extends JpaRepository<User,Long> {


    Optional<User> findByuserName(String userName);
}
