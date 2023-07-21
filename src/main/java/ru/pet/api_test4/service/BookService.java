package ru.pet.api_test4.service;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ru.pet.api_test4.dto.BookDto;
import ru.pet.api_test4.error.NotFoundException;
import ru.pet.api_test4.entities.BookEntity;
import ru.pet.api_test4.mapper.BookListMapper;
import ru.pet.api_test4.mapper.BookMapper;
import ru.pet.api_test4.repository.BookRepository;

import java.util.*;

/**
 * Сервис для работы с книгами
 */
@Service
@Validated
public class BookService {
    private final String NOT_FOUND_BOOK = "Книга не найдена";
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final BookListMapper bookListMapper;

    public BookService(BookRepository bookRepository, BookMapper bookMapper, BookListMapper bookListMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
        this.bookListMapper = bookListMapper;
    }

    /**
     * Создание новой позиции на складе
     *
     * @param bookDto - новая книга
     */
    public void create(@Valid BookDto bookDto) {
        BookEntity bookEntity = bookMapper.toEntity(bookDto);
        bookRepository.save(bookEntity);
    }

    /**
     * Возвращает список всех имеющихся книг
     *
     * @return список книг
     * @throws NotFoundException если список книг пуст
     */
    public List<BookDto> readAll()  throws NotFoundException  {
        return bookListMapper.toBookDtoList(bookRepository.findAll());
    }

    /**
     * Возвращает книгу по ее id
     *
     * @param id - ID книги
     * @return - объект книги с заданным id
     * @throws NotFoundException если книга не найдена
     */
    public BookDto read(int id) throws NotFoundException {
        return bookMapper.toDto(bookRepository.findById(id).orElseThrow(() -> new NotFoundException(NOT_FOUND_BOOK)));
    }
}
