package com.example.sd2020.demo.model;

import com.example.sd2020.demo.repository.ClientRepository;

public class FacadeClient {

    private ClientRepository clientRepository;

    public FacadeClient(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    /**
     *
     * @param id -> id-ul clientului
     * @return -> clientul cu id-ul cautat
     */
    public Client getClientId(int id){
        return clientRepository.findById(id);
    }

    /**
     *
     * @param name -> numele clientului cautat
     * @return -> obiectul client cu numele cautat
     */
    public Client getClientByName(String name){
        return clientRepository.findClientByName(name);
    }

}
