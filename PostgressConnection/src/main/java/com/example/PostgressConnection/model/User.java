package com.example.PostgressConnection.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Entity
    public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        public Long id;
        public String userName;
        public String password;
    }

