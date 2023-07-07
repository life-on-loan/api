package ru.pet.api_test4.controller;

import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.pet.api_test4.dto.BookDto;
import ru.pet.api_test4.dto.NotFoundException;

import java.util.List;

public interface BookController {

    /**
     * Создание новой книги в базе
     *
     * @param book - новая книга
     * @return
     */
    @PostMapping
    ResponseEntity<?> create(@RequestBody BookDto book);

    /**
     * Чтение всего списка книг в базе
     *
     * @return список имеющихся книг
     */
    @GetMapping
    ResponseEntity<List<BookDto>> read();

    /**
     * Чтение данных одной книги по ее id
     *
     * @param id - id книги
     * @return данные искомой книги
     */
    @GetMapping
    ResponseEntity<BookDto> read(@PathVariable(name = "id_book") @NotNull int id) throws NotFoundException;
}

