package ru.pet.api_test4.service;


import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ru.pet.api_test4.dto.BookDto;
import ru.pet.api_test4.dto.CartDto;
import ru.pet.api_test4.dto.OrderPositionDto;
import ru.pet.api_test4.entities.BookEntity;
import ru.pet.api_test4.entities.CartElement;
import ru.pet.api_test4.error.NotFoundException;
import ru.pet.api_test4.entities.CartEntity;
import ru.pet.api_test4.mapper.*;
import ru.pet.api_test4.repository.CartRepository;

import java.util.*;

/**
 * Сервис для работы с корзинами покупателей
 */
@Service
@Validated
public class CartService {
    private final CartRepository cartRepository;
    private final CartListMapper cartListMapper;

    /**
     * Экземпляр сервиса для работы с книгами
     */
    private final BookService bookService;
    private final BookMapper bookMapper;

    public CartService(CartRepository cartRepository, CartListMapper cartListMapper, BookService bookService, BookMapper bookMapper) {
        this.cartRepository = cartRepository;
        this.cartListMapper = cartListMapper;
        this.bookService = bookService;
        this.bookMapper = bookMapper;
    }

    /**
     * Создание новой корзины
     *
     * @param cartDto - новая корзина
     * @throws NotFoundException если добавляемая в корзину книга не найдена
     */
    public void create(CartDto cartDto) throws NotFoundException {
        var cart = new CartEntity();

        for (int i = 0; i < cartDto.getIdBook().size(); i++) {
            var cartElement = new CartElement();
            Integer bookId = cartDto.getIdBook().get(i);
            BookEntity bookFromDb = bookMapper.toEntity(bookService.read(bookId));
            cartElement.setBook(bookFromDb);
            cartElement.setAmount(cartDto.getCountBooks().get(i));
            cartElement.setCart(cart);
            bookFromDb.getCartElements().add(cartElement);
            cart.getCartElements().add(cartElement);
        }
        cartRepository.save(cart);
    }

    /**
     * Добавление новой книги в корзину
     *
     * @param id     - id корзины
     * @param data   - данные о добавляемой позиции заказа
     * @throws NotFoundException если добавляемая в корзину книга не найдена
     */
    public boolean add(int id, @Valid OrderPositionDto data) throws NotFoundException {
        int idBook = data.getIdBook();
        int count = data.getCount();
        if (cartRepository.findById(id).isPresent()) {
            CartEntity cart = cartRepository.findById(id).get();
            boolean isBookInCart = false;

            List<CartElement> cartElements = cart.getCartElements();
            for (CartElement element : cartElements) {
                if (isBookInCart) {
                    break;
                }
                BookEntity bookEntity = element.getBook();
                if (idBook == bookEntity.getIdBook()) {
                    isBookInCart = true;
                    element.setAmount(element.getAmount() + count);
                }
            }

            if (!isBookInCart) {
                CartElement cartElement = new CartElement();
                cartElement.setCart(cart);
                cartElement.setBook(bookMapper.toEntity(bookService.read(idBook)));
                cartElement.setAmount(count);
                cart.getCartElements().add(cartElement);
            }
            cartRepository.save(cart);
            return true;
        }
        return false;
    }

    /**
     * Удаление корзины
     *
     * @param id - id корзины
     */
    public boolean delete(int id) {
        cartRepository.deleteById(id);
        return cartRepository.findById(id).isPresent();
    }

    /**
     * Возвращает список всех имеющихся корзин
     * @return список корзин
     * @throws NotFoundException если список корзин пуст
     */
    public List<CartDto> readAll() throws NotFoundException {
        return cartListMapper.toCartDtoList(cartRepository.findAll());
    }
}
