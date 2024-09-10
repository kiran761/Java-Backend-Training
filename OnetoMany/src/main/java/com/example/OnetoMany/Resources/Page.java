package com.example.OnetoMany.Resources;


import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "pages")
public class Page implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int number;
    private String content;
    private String chapter;

    //@ManyToOne(fetch = FetchType.LAZY, optional = false)
    // @JoinColumn(name = "book_id", nullable = false)
    //private Book book;

    public Page() {
    }

    public Page(int number, String content, String chapter) {
        this.number = number;
        this.content = content;
        this.chapter = chapter;

    }

//    public Page(int number, String content, String chapter, Book book) {
//        this.number = number;
//        this.content = content;
//        this.chapter = chapter;
//        this.book = book;
//    }

    // getters and setters, equals(), toString() .... (omitted for brevity)
}
