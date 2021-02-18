package com.example.sd2020.demo.model;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

public interface BookOperations {

    Book getBookById(@PathVariable String id) throws Exception;
    ResponseEntity<Object> createBook(@PathVariable String title, @PathVariable String author, @PathVariable int copies);
    public Book getBookByTitle(@PathVariable String title) throws Exception;
    public void deleteAll();


}
