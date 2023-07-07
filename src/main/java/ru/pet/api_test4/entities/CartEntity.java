package ru.pet.api_test4.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Data
@Table(name = "cart")
public class CartEntity {
    @Id
    @Column(name = "id_cart")
    @GeneratedValue(strategy = IDENTITY)
    Integer idCart;

    @Column(name = "name_books")
    @ElementCollection
    List<String> nameBooks;

    @Column(name = "cost_books")
    @ElementCollection
    List<Float> costBooks;

    @Column(name = "count_books")
    @ElementCollection
    List<Integer> countBooks;

    public Integer getIdCart() {
        return idCart;
    }

    public void setIdCart(Integer idCart) {
        this.idCart = idCart;
    }

    public List<String> getNameBooks() {
        return nameBooks;
    }

    public void setNameBooks(List<String> nameBooks) {
        this.nameBooks = nameBooks;
    }

    public List<Float> getCostBooks() {
        return costBooks;
    }

    public void setCostBooks(List<Float> costBooks) {
        this.costBooks = costBooks;
    }

    public List<Integer> getCountBooks() {
        return countBooks;
    }

    public void setCount(List<Integer> count) {
        this.countBooks = count;
    }
}
