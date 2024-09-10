package com.example.OnetoMany;

import com.example.OnetoMany.Repos.BookRepository;
import com.example.OnetoMany.Repos.PageRepository;
import com.example.OnetoMany.Resources.Book;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OnetoManyApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnetoManyApplication.class, args);
	}

}

@Bean
public CommandLineRunner mappingDemo(BookRepository bookRepository, PageRepository pageRepository)
{
	Book book=Book("Spring Boot","");
}
