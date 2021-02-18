package com.example.sd2020.demo.controller;

import com.example.sd2020.demo.model.Book;
import com.example.sd2020.demo.model.BookOperations;
import com.example.sd2020.demo.model.Client;
import com.example.sd2020.demo.repository.BookRepository;
import com.example.sd2020.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;



@RestController
@RequestMapping(path = "/books")
public class BookController implements BookOperations {

    private BookRepository bookRepository;
    private BookService bookService;

    @Autowired
    public BookController(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public BookController(){


    }

    /**
     * Metoda folosita pentru a gasi in biblioteca o carte pe baza id-ului
     *
     * @param id -> id-ul cartii. I se face cast de la String la Int
     * @return -> se returneaza obiectul carte in cazul in care se gaseste in biblioteca, altfel null
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value="getBookById/{id}", method = RequestMethod.GET)
    public Book getBookById(@PathVariable String id) throws Exception {


        int idInt = Integer.parseInt(id);
        Book book = bookRepository.findById(idInt);
        if(book == null) throw new Exception("We haven't" + book.getTitle() + " with ID: " + book.getId());
        return book;

    }

    /**
    * Metoda folosita pentru a gasi in biblioteca o carte pe baza titlui
    *
    * @param title -> numele cartii
    * @return -> se returneaza obiectul carte in cazul in care se gaseste in biblioteca, altfel null
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value="getBookByTitle/{title}", method = RequestMethod.GET)
    public Book getBookByTitle(@PathVariable String title) throws Exception {
        Book x = bookRepository.getBookByTitle(title);
        if(x == null)
            throw new Exception("We haven't +" + title + "in our biblio");
        return bookRepository.getBookByTitle(title);

    }

    /**
    * Aceasta metoda este folosita pentru a crea si a adauga in BD o noua carte
    *
    * @param title -> titlul cartii
    * @param author -> numele autorului
    * @param copies -> numarul de copii ale acestui exemplar
    * @return -> locatia noii carti
     */

    @RequestMapping(value="/addBook/{title}/{author}/{copies}", method = RequestMethod.POST)
    public ResponseEntity<Object> createBook(@PathVariable String title, @PathVariable String author, @PathVariable int copies){

        Book book = new Book(title, author, copies);
        Book saveBook = bookRepository.save(book);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saveBook.getId()).toUri();
        return ResponseEntity.created(location).build();
    }



    /**
     * Cu aceasta metoda se afiseaza toate item-urile existente in BD numita book
     *
     * @return -> lista de carti existenta in BD
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value="/getBooks",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Book>> getProducts() {
        return new ResponseEntity<>(bookRepository.findAll(),null, HttpStatus.OK);
    }

    /**
     * Sterge toate obiectele existente in BD numita book
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value="/deleteAll", method = RequestMethod.GET)
    public void deleteAll(){
        bookService.deleteAll();
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/deleteBookByTitle/{nume}", method = RequestMethod.POST)
    public void deleteBookByTitle(@PathVariable String nume) throws Exception {

        Book book = bookRepository.getBookByTitle(nume);
        if(book != null) bookRepository.delete(book);
        else{
            throw new Exception("Didn't find this book title !");
        }
    }
}
