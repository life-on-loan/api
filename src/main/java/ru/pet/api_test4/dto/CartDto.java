package ru.pet.api_test4.dto;


import java.util.List;

import lombok.Data;

@Data
public class CartDto {
    private Integer idCart;
    private List<Integer> idBook;
    private List<Integer> countBooks;

    public Integer getIdCart() {
        return idCart;
    }

    public void setIdCart(Integer id) {
        this.idCart = id;
    }

    public List<Integer> getCountBooks() {
        return countBooks;
    }

    public void setCountBooks(List<Integer> count) {
        this.countBooks = count;
    }
}
