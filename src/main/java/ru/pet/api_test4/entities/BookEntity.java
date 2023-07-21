package ru.pet.api_test4.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;


@Entity
@Data
@Table(name = "book")
public class BookEntity {
    @Id
    @Column(name = "id_book", nullable = false)
    @GeneratedValue(strategy = IDENTITY)
    Integer idBook;

    @Column(name = "name_book", nullable = false)
    String nameBook;

    @Column(name = "author")
    String author;

    @Column(name = "genre")
    String genre;

    @Column(name = "cost_book")
    Float costBook;

    @Column(name = "count_pages")
    Integer countPages;

    @Column(name = "description")
    String description;

    @OneToMany(mappedBy = "book")
    @Column(name = "cart_elements")
    List<CartElement> cartElements = new ArrayList<>();

    public List<CartElement> getCartElements() {
        return cartElements;
    }

    public void setCartElements(List<CartElement> cartElements) {
        this.cartElements = cartElements;
    }

    public Integer getIdBook() {
        return idBook;
    }

    public void setIdBook(Integer idBook) {
        this.idBook = idBook;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Float getCostBook() {
        return costBook;
    }

    public void setCostBook(Float costBook) {
        this.costBook = costBook;
    }

    public Integer getCountPages() {
        return countPages;
    }

    public void setCountPages(Integer countPages) {
        this.countPages = countPages;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
