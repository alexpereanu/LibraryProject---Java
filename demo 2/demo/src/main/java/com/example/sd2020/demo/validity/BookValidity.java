package com.example.sd2020.demo.validity;

import com.example.sd2020.demo.model.Book;
import com.example.sd2020.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class BookValidity {

    public BookRepository bookRepository;

    @Autowired
    public BookValidity(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public Book getBookByIdVerified(String id) throws Exception {

        int idInt = Integer.parseInt(id);
        Book book = bookRepository.findById(idInt);
        if(book == null) throw new Exception("We haven't" + book.getTitle() + " with ID: " + book.getId());
        return book;
    }
}
