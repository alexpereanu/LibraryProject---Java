package com.example.sd2020.demo.arch;

import javax.persistence.*;
import java.util.Random;

@Entity
@Table
public class Book {

    @Id
    @GeneratedValue
    private int id;
    @Column
    private String title;
    @Column
    private String author;
    @Column
    private int numberOfCopies;


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
