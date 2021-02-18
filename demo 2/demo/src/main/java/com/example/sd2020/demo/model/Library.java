package com.example.sd2020.demo.model;

import com.example.sd2020.demo.repository.BookRepository;

import javax.persistence.*;

@Entity
@Table
/**
 * Entitatea Library
 */
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String numeClient;

    @Column
    private String numeCarte;

    public Library() {
    }

    public Library(String clientName, String bookName) {

        this.numeClient = clientName;
        this.numeCarte = bookName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeClient() {
        return numeClient;
    }

    public void setNumeClient(String numeClient) {
        this.numeClient = numeClient;
    }

    public String getNumeCarte() {
        return numeCarte;
    }

    public void setNumeCarte(String numeCarte) {
        this.numeCarte = numeCarte;
    }
}
