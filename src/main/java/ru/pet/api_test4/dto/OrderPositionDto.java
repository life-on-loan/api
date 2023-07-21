package ru.pet.api_test4.dto;

import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class OrderPositionDto {
    private Integer idBook;
    @Min(1)
    private Integer count;

    public Integer getIdBook() {
        return idBook;
    }

    public void setIdBook(Integer idBook) {
        this.idBook = idBook;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
