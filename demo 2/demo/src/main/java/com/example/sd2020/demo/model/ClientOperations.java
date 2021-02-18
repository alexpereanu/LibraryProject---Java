package com.example.sd2020.demo.model;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

public interface ClientOperations {

    public Client getClientByName(@PathVariable String nameClient) throws Exception;

    public ResponseEntity<Object> createClient(@PathVariable String nume, @PathVariable String prenume, @PathVariable String telefon);

    public Client getClientById(@PathVariable String id) throws Exception;



}
