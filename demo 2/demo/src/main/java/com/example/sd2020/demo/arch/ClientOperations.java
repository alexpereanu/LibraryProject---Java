package com.example.sd2020.demo.arch;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

public interface ClientOperations {

    public Client getClientByName(@PathVariable String nameClient) throws Exception;

    public void rentBook(@PathVariable String numeClient, @PathVariable String numeCarte);

    public void returnBook(@PathVariable String numeClient, @PathVariable String numeCarte);

    public ResponseEntity<Object> createClient(@PathVariable String nume, @PathVariable String prenume, @PathVariable String telefon);



}
