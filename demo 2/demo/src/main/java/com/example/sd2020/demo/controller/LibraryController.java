package com.example.sd2020.demo.controller;

import com.example.sd2020.demo.model.*;
import com.example.sd2020.demo.repository.BookRepository;
import com.example.sd2020.demo.repository.ClientRepository;
import com.example.sd2020.demo.repository.LibraryRepository;
import com.example.sd2020.demo.util.User;
import com.example.sd2020.demo.util.UserFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping(path = "/library")
public class LibraryController {

    private BookRepository bookRepository;
    private ClientRepository clientRepository;
    private LibraryRepository libraryRepository;

    public LibraryController(ClientRepository clientRepository, BookRepository bookRepository, LibraryRepository libraryRepository) {

        this.clientRepository = clientRepository;
        this.bookRepository = bookRepository;
        this.libraryRepository = libraryRepository;
    }

    /**
     * Se creeaza o noua inchiriere, unui client i se atribuie un nou id pe baza cartii imprumutate
     * Daca exista cartea cu titlul dorit in biblioteca si daca numarul de exemplare aferent cartii este mai mare de 0 atunci se face imprumutul, altfel
     * se arunca o exceptie
     *
     * @param clientName -> string-ul care reprezinta numele clientului
     * @param bookName -> string-ul care reprezinta titlul cartii
     * @return -> returneaza locatia imprumutului creat
     */

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/createNewRent/{clientName}/{bookName}", method = RequestMethod.POST)
    public ResponseEntity<Object> createNewRent(@PathVariable String clientName, @PathVariable String bookName) throws Exception {

        UserFactory userFactory = new UserFactory();
        User client = userFactory.getUser("Client");
        User book = userFactory.getUser("Book");

        List<Library> repoLibrary = libraryRepository.findAll();
        for(Library item: repoLibrary){
            if(item == null){
                Library library = new Library(clientName, bookName);
                libraryRepository.save(library);
                break;
            }
            if(item.getNumeClient().equalsIgnoreCase(clientName) && item.getNumeCarte().equalsIgnoreCase(bookName)){
                throw new Exception("Client: " + clientName + " had already rent " + bookName);
            }
        }

        if (client instanceof Client && book instanceof Book) {
            client = clientRepository.findClientByName(clientName);
            if (client == null) {
                throw new Exception(clientName + " isn't in our base !");
            }
            book = bookRepository.getBookByTitle(bookName);
            if (book == null) {
                throw new Exception(bookName + " isn't in our library !");
            }
            if (((Book) book).getNumberOfCopies() > 0) {
                ((Book) book).decrementNumberOfCopies();
                ((Client)client).setCartiImprumutate(bookName);
            } else throw new Exception("We don't have any copies of this title !" + ((Book) book).getTitle());

            bookRepository.save((Book) book);
            clientRepository.save((Client)client);
            Library library = new Library(clientName, bookName);
            libraryRepository.save(library);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(library.getId()).toUri();
            return ResponseEntity.created(location).build();

        } else throw new Exception("Problem with Factory Pattern !");
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/getLibrary", method = RequestMethod.GET)
    public ResponseEntity<List<Library>> getLibrary() {
        return new ResponseEntity<>(libraryRepository.findAll(),null, HttpStatus.OK);
    }
    /**
     * Dupa ce se fac anumite inchirieri, clientii o sa returneze cartile pe masura ce le citesc.
     * Aceasta metoda are rolul de a indeplini returnarea cartilor.
     * Se verifica daca clientul primit ca si parametru este in baza de date a librariei si daca acest client are asociat titlul cartii pe care se presupune ca a citit-o
     * In cazul in care conditia de mai sus nu a fost indeplinita se arunca o exceptie, altfel se executa return-ul
     *
     * @param clientName -> string-ul care reprezinta numele clientului
     * @param bookName -> string-ul care reprezinta titlul cartii
     * @return -> void, nu returnam nimic

     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/returnBook/{clientName}/{bookName}", method = RequestMethod.POST)
    public void returnBook(@PathVariable String clientName, @PathVariable String bookName) throws Exception {

        UserFactory userFactory = new UserFactory();
        User client = userFactory.getUser("Client");
        User book = userFactory.getUser("Book");

        if (client instanceof Client && book instanceof Book) {
            client = clientRepository.findClientByName(clientName);
            if (client == null) {
                throw new Exception(clientName + " isn't in our base !");
            }
            book = bookRepository.getBookByTitle(bookName);
            if (book == null) {
                throw new Exception(bookName + " isn't in our library !");
            }

            boolean returned = false;
            List<Library> repoLibrary = libraryRepository.findAll();
            for(Library item: repoLibrary){
                if(item.getNumeClient().equalsIgnoreCase(clientName) && item.getNumeCarte().equalsIgnoreCase(bookName)){
                    libraryRepository.delete(item);
                    returned = true;
                    ((Book)book).incrementNumberOfCopies();
                    bookRepository.save((Book) book);
                }
            }
            if(returned == false){
                throw new Exception("The client or the book isn't in our DB !");
            }

        } else throw new Exception("Problem with Factory Pattern !");
    }
}
