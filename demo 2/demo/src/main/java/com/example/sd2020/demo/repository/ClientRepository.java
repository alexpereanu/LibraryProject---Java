package com.example.sd2020.demo.repository;

import com.example.sd2020.demo.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


/*
 * Repository-ul folosit de clasa ClientController pentru implementarea metodelor sale.
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, Integer>{

    Client findById(int id);

    @Query("SELECT c FROM Client c WHERE c.nume = :nume")
    Client findClientByName(@Param("nume") String nume);

    void deleteAll();


}
