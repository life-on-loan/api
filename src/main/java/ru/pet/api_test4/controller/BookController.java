package ru.pet.api_test4.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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
    ResponseEntity<?> create(@RequestBody BookDto book);

    /**
     * Чтение всего списка книг в базе
     *
     * @return список имеющихся книг
     */
    ResponseEntity<List<BookDto>> read();

    /**
     * Чтение данных одной книги по ее id
     *
     * @param id - id книги
     * @return данные искомой книги
     */
    ResponseEntity<BookDto> read(@PathVariable(name = "id") int id) throws NotFoundException;
}

