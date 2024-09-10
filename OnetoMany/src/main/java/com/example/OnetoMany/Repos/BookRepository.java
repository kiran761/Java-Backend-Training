package com.example.OnetoMany.Repos;

import com.example.OnetoMany.Resources.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {
}
