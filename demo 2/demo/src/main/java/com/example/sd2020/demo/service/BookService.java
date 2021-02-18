package com.example.sd2020.demo.service;

import com.example.sd2020.demo.model.Book;
import com.example.sd2020.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public void deleteAll(){
        bookRepository.deleteAll();
    }

    public List<Book> getAll(){
        return bookRepository.findAll();
    }

    public Book getBookByTitle(String title){
        return bookRepository.getBookByTitle(title);
    }

    public Book getBookById(String id){
        return bookRepository.findById(Integer.parseInt(id));
    }


}
