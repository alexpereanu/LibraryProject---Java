package com.example.sd2020.demo.storage;

import com.example.sd2020.demo.util.Observer;
import com.example.sd2020.demo.model.Book;
import com.example.sd2020.demo.model.Client;
import com.example.sd2020.demo.controller.BookController;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class Biblioteca {

    private ArrayList<Client> clienti;
    private ArrayList<Book> carti;
    private ArrayList<Observer> observers;
    private BookController bookController;

    public Biblioteca(){
        this.clienti = new ArrayList<>();
        this.carti = new ArrayList<>();
        this.observers = new ArrayList<>();
        this.bookController = new BookController();
    }


    public void addObserver(Observer observer){
        this.observers.add(observer);
    }

    public void removeObserver(Observer observer){
        this.observers.remove(observer);
    }

    public String addNewBook(Book book){

        RedirectAttributes attr = new RedirectAttributes() {
            @Override
            public RedirectAttributes addAttribute(String s, Object o) {
                return null;
            }

            @Override
            public RedirectAttributes addAttribute(Object o) {
                return null;
            }

            @Override
            public RedirectAttributes addAllAttributes(Collection<?> collection) {
                return null;
            }

            @Override
            public RedirectAttributes mergeAttributes(Map<String, ?> map) {
                return null;
            }

            @Override
            public RedirectAttributes addFlashAttribute(String s, Object o) {
                return null;
            }

            @Override
            public RedirectAttributes addFlashAttribute(Object o) {
                return null;
            }

            @Override
            public Map<String, ?> getFlashAttributes() {
                return null;
            }

            @Override
            public Model addAllAttributes(Map<String, ?> map) {
                return null;
            }

            @Override
            public boolean containsAttribute(String s) {
                return false;
            }

            @Override
            public Object getAttribute(String s) {
                return null;
            }

            @Override
            public Map<String, Object> asMap() {
                return null;
            }
        };
        attr.addFlashAttribute(book);
        this.carti.add(book);
        for(Observer observer: this.observers){
            observer.update(book.getTitle());
        }
        return "redirect:/createBook(attr)";
    }

    public ArrayList<Book> getCarti() {
        return carti;
    }

    public void getBooks(){
        bookController.getProducts();
    }
}
