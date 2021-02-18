package com.example.sd2020.demo.controller;


import com.example.sd2020.demo.util.User;
import com.example.sd2020.demo.util.UserFactory;
import com.example.sd2020.demo.model.Client;
import com.example.sd2020.demo.model.ClientOperations;
import com.example.sd2020.demo.repository.BookRepository;
import com.example.sd2020.demo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping(path = "/client")
public class ClientController implements ClientOperations {

    private ClientRepository clientRepository;
    private BookRepository bookRepository;

    @Autowired
    public ClientController(ClientRepository clientRepository, BookRepository bookRepository) {
        this.clientRepository = clientRepository;
        this.bookRepository = bookRepository;
    }
    /**
     * Metoda folosita pentru a gasi in tabela client un client identificat dupa ID
     *
     * @param id -> id-ul clientului. Se apeleaza metoda getClientById() din cadrul clasei ClientValidity
     * @return -> se returneaza obiectul client in cazul in care se gaseste in tabela, altfel null
    */
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "getClientById/{id}", method = RequestMethod.GET)
    public Client getClientById(@PathVariable String id) throws Exception {

        Client client = getClientById(id);
        return client;
    }

    /**
    * Se cauta in tabela client un anume client identificat dupa nume.
    * Se creeaza un obiect Client folosind Factory Pattern, iar in cazul in care se gaseste in tabela un client care are numele primit ca
    * parametru al functiei, i se atribuie obiectului creat cu Factory valoarea obiectului client gasit de metoda
    *
    * @param nameClient -> numele clientului cautat in tabela
    * @return Client -> obiectul Client in cazul in care se gaseste, altfel null
     */
    @CrossOrigin(origins = "*")
    @GetMapping(value="/getClientByName/{nameClient}")
    public Client getClientByName(@PathVariable String nameClient) throws Exception {

        UserFactory userFactory = new UserFactory();
        User user = userFactory.getUser("Client");

        if(user instanceof Client) {
            user = clientRepository.findClientByName(nameClient);
            if (user == null) throw new Exception(nameClient + " isn't in our DB !");
            return (Client) user;
        }

        return null;
    }

    /**
     * Aceasta metoda este folosita pentru a crea si a adauga in BD un nou client
     *
     * @param nume -> numele clientului
     * @param prenume -> prenumele clientului
     * @param telefon -> telefonul clientului
     * @return -> locatia noului client
     */
    @CrossOrigin(origins = "*")
    @PostMapping(value = "/createNewClient/{nume}/{prenume}/{telefon}")
    public ResponseEntity<Object> createClient(@PathVariable String nume, @PathVariable String prenume, @PathVariable String telefon){

        Client client = new Client(nume, prenume, telefon);
        Client saveClient = clientRepository.save(client);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saveClient.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    /**
    * Aceasta metoda returneaza o lista cu toti clientii existenti in tabela client
    *
    * @return -> o lista de clienti
     */

    @CrossOrigin(origins = "*")
    @RequestMapping(value="/getClients",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Client>> getClients() {
        return new ResponseEntity<>(clientRepository.findAll(),null, HttpStatus.OK);
    }

    /**
     * Aceasta metoda sterge toti clientii existenti in tabela

     * @return -> nimic, functie void
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/deleteAllClients", method = RequestMethod.GET)
    public void deleteAll(){
        clientRepository.deleteAll();

    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/deleteClientByName/{nume}", method = RequestMethod.POST)
    public void deleteClientByName(@PathVariable String nume) throws Exception {

        Client client = clientRepository.findClientByName(nume);
        if(client != null){
            clientRepository.delete(client);
        }
    }


}
