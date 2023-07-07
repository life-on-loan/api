package ru.pet.api_test4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pet.api_test4.dto.BookDto;
import ru.pet.api_test4.dto.NotFoundException;
import ru.pet.api_test4.entities.BookEntity;
import ru.pet.api_test4.mapper.BookListMapperImpl;
import ru.pet.api_test4.mapper.BookMapperImpl;
import ru.pet.api_test4.repository.BookRepository;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Сервис для работы с книгами
 */
@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private final BookMapperImpl bookMapperImpl = new BookMapperImpl();
    @Autowired
    private final BookListMapperImpl bookListMapper = new BookListMapperImpl(bookMapperImpl);

    /**
     * Переменная для генерации ID книги
     */
    private static final AtomicInteger BOOK_ID_HOLDER = new AtomicInteger();

    /**
     * Создание новой позиции на склад
     *
     * @param bookDto - новая книга
     */
    public void create(BookDto bookDto) {
        final int bookId = BOOK_ID_HOLDER.incrementAndGet();
        bookDto.setIdBook(bookId);
        BookEntity bookEntity = bookMapperImpl.toEntity(bookDto);
        bookRepository.save(bookEntity);
    }

    /**
     * Возвращает список всех имеющихся книг
     *
     * @return список книг
     */
    public List<BookDto> readAll() {
        Iterable<BookEntity> booksIterable = bookRepository.findAll();
        List<BookEntity> books = new ArrayList<>();
        booksIterable.forEach(books::add);
        return bookListMapper.toBookDtoList(books);
    }

    /**
     * Возвращает книгу по ее id
     *
     * @param id - ID книги
     * @return - объект книги с заданным id
     */
    public BookDto read(int id) throws NotFoundException {
        return bookMapperImpl.toDto(bookRepository.findById(id).orElseThrow(() -> new NotFoundException("Книга не найдена")));
    }
}
