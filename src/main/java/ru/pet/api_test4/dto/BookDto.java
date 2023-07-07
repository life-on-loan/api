package ru.pet.api_test4.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class BookDto {
    private Integer idBook;
    //@NotEmpty
    private String nameBook;
    private String author;
    private String genre;
    private Float costBook;
    private Integer countPages;
    private String description;

    public Integer getIdBook() {
        return idBook;
    }

    public void setIdBook(Integer id) {
        this.idBook = id;
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
