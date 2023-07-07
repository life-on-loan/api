package ru.pet.api_test4.dto;


import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class CartDto {
    @NotNull
    private Integer idCart;
    @NotBlank
    private List<String> nameBooks;
    @Positive
    private List<Float> costBooks;
    @Positive
    private List<Integer> countBooks;

    public Integer getIdCart() {
        return idCart;
    }

    public void setIdCart(Integer id) {
        this.idCart = id;
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

    public void setCostBooks(List<Float> cost) {
        this.costBooks = cost;
    }

    public List<Integer> getCountBooks() {
        return countBooks;
    }

    public void setCountBooks(List<Integer> count) {
        this.countBooks = count;
    }
}
