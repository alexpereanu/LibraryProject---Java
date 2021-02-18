package com.example.sd2020.demo.validity;

import com.example.sd2020.demo.model.Client;
import com.example.sd2020.demo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ClientValidity {

    public ClientRepository clientRepository;

    @Autowired
    public ClientValidity(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    public Client getClientById(String id) throws Exception{

        int idInt = Integer.parseInt(id);
        Client client = clientRepository.findById(idInt);
        if(client == null) throw new Exception("We haven't this client with ID: " + id);
        return client;
    }


}
