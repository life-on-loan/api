package ru.pet.api_test4.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.pet.api_test4.dto.BookDto;
import ru.pet.api_test4.error.NotFoundException;

import java.util.List;

@RequestMapping("/book")
public interface BookController {

    /**
     * Создание новой книги в базе
     *
     * @param book - новая книга
     * @return статус выполнения операции
     */
    @PostMapping
    ResponseEntity<?> create(@RequestBody BookDto book);

    /**
     * Чтение всего списка книг в базе
     *
     * @return список имеющихся книг
     */
    @GetMapping
    ResponseEntity<List<BookDto>> read() throws NotFoundException;

    /**
     * Чтение данных одной книги по ее id
     *
     * @param id - id книги
     * @return данные искомой книги
     */
    @GetMapping("/{id_book}")
    ResponseEntity<BookDto> read(@PathVariable(name = "id_book") int id) throws NotFoundException;
}

