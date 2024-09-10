package com.example.RestJpaSql.repository;

import com.example.RestJpaSql.entity.product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface productRepo extends JpaRepository<product,Long> {
}
