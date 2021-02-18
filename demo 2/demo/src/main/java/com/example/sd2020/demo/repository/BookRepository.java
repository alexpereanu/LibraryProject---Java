package com.example.sd2020.demo.repository;

import com.example.sd2020.demo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
/*
    * Repository-ul folosit de clasa BookController pentru implementarea metodelor sale.
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    Book getBookByTitle(String title);

    void deleteAll();

    List<Book> findAll();

    Book findById(int id);

}
