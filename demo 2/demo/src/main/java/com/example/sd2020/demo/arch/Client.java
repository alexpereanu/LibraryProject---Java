package com.example.sd2020.demo.arch;


import com.example.sd2020.demo.DesignPattern.Observer;
import com.example.sd2020.demo.DesignPattern.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Client implements Observer, User {


    private String newBook;

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String nume;

    @Column
    private String prenume;

    @Column
    private String telefon;

   @Column
    private String cartiImprumutate = "";

    public Client(){
    }

    public Client(String nume, String prenume, String telefon){
        this.nume = nume;
        this.prenume = prenume;
        this.telefon = telefon;
        //this.cartiImprumutate = " ";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getNewBook() {
        return newBook;
    }

    public void setNewBook(String newBook) {
        this.newBook = newBook;
    }

    public void update(String carte){
        this.setNewBook(carte);
    }

    public String getCartiImprumutate() {
        return cartiImprumutate;
    }

    public void setCartiImprumutate(String cartiImprumutate) {

        this.cartiImprumutate = this.cartiImprumutate + cartiImprumutate + ", ";
    }

    public void updateCartiImprumutate(String cartiImprumutate){

        this.cartiImprumutate = "";
        this.cartiImprumutate = cartiImprumutate;
    }

    public void sayWhoYouAre(){

        System.out.println("I am a client ! ");
    }


}
