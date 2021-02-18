package com.example.sd2020.demo.service;

import com.example.sd2020.demo.model.Client;
import com.example.sd2020.demo.repository.ClientRepository;

public class ClientService {

    private ClientRepository clientRepository;

    public void deleteAll(){
        clientRepository.deleteAll();
    }

    public void getClients(){
        clientRepository.findAll();
    }

    public void getClientById(String id){

    }
}
