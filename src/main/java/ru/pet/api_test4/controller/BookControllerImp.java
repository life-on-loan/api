package ru.pet.api_test4.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.pet.api_test4.dto.BookDto;
import ru.pet.api_test4.dto.NotFoundException;
import ru.pet.api_test4.service.BookService;

import java.util.List;

@Validated
@RestController
@RequestMapping("/books")
public class BookControllerImp implements BookController {

    private final BookService bookService;

    @Autowired
    public BookControllerImp(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody BookDto book) {
        bookService.create(book);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<BookDto>> read() {
        final List<BookDto> books = bookService.readAll();
        return books != null && !books.isEmpty()
                ? new ResponseEntity<>(books, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    @GetMapping("/{idBook}")
    public ResponseEntity<BookDto> read(@PathVariable(name = "idBook") @NotNull int id) throws NotFoundException {
        final BookDto book = bookService.read(id);

        return book != null
                ? new ResponseEntity<>(book, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
