package com.example.sd2020.demo.model;

import com.example.sd2020.demo.repository.BookRepository;
import org.springframework.web.bind.annotation.PathVariable;

public class FacadeBook {

    private BookRepository bookRepository;

    public FacadeBook(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public Book getBookId(int id){
       return bookRepository.findById(id);

    }

    public Book getBookByTitle(@PathVariable String title) throws Exception{
        return bookRepository.getBookByTitle(title);

    }

    public void deleteAll(){
        bookRepository.deleteAll();
    }


}
