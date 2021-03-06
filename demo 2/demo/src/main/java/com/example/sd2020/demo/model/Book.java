package com.example.sd2020.demo.model;

import com.example.sd2020.demo.util.User;

import javax.persistence.*;

@Entity
@Table
/**
 * Aceasta este entitatea Book.
 */
public class Book implements User {

    @Id
    @GeneratedValue
    private int id;
    @Column
    private String title;
    @Column
    private String author;
    @Column
    private int numberOfCopies;

    //@OneToOne(mappedBy = "book")
    //private Library library;


    public Book(String title, String author, int numberOfCopies){
        this.id = (int)Math.random();
        this.title = title;
        this.author = author;
        this.numberOfCopies = numberOfCopies;
    }

    public Book(){

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getNumberOfCopies() {
        return numberOfCopies;
    }

    public void setNumberOfCopies(int numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }

    public void decrementNumberOfCopies(){
        this.numberOfCopies -= 1;
    }

    public void incrementNumberOfCopies(){
        this.numberOfCopies += 1;
    }

    public void sayWhoYouAre(){

        System.out.println("I am a book ! ");
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", numberOfCopies=" + numberOfCopies +
                '}';
    }
}
