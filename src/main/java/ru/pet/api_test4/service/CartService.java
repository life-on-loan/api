package ru.pet.api_test4.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pet.api_test4.dto.BookDto;
import ru.pet.api_test4.dto.CartDto;
import ru.pet.api_test4.dto.NotFoundException;
import ru.pet.api_test4.entities.CartEntity;
import ru.pet.api_test4.mapper.CartListMapperImpl;
import ru.pet.api_test4.mapper.CartMapperImpl;
import ru.pet.api_test4.repository.CartRepository;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Сервис для работы с корзинами покупателей
 */
@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private final CartMapperImpl cartMapperImpl = new CartMapperImpl();
    @Autowired
    private final CartListMapperImpl cartListMapper = new CartListMapperImpl(cartMapperImpl);

    /**
     * Переменная для генерации ID козины
     */
    private static final AtomicInteger CART_ID_HOLDER = new AtomicInteger();

    /**
     * Экземпляр сервиса для работы с книгами
     */
    private static final BookService bookService = new BookService();

    /**
     * Создание новой корзины
     *
     * @param cartDto - новая корзина
     */
    public void create(CartDto cartDto) {
        final int cartId = CART_ID_HOLDER.incrementAndGet();
        cartDto.setIdCart(cartId);
        CartEntity cartEntity = cartMapperImpl.toEntity(cartDto);
        cartRepository.save(cartEntity);
    }

    /**
     * Добавление новой книги в корзину
     *
     * @param id     - id корзины
     * @param idBook - id добавляемой книги
     * @param count  - количество добавляемых книг
     */
    public boolean add(int id, int idBook, int count) throws NotFoundException {
        Object book1 = bookService.read(idBook);
        if (cartRepository.findById(id).isPresent() && book1 instanceof BookDto) {
            BookDto bookDto = (BookDto) book1;
            CartDto cart = cartMapperImpl.toDto(cartRepository.findById(id).get());
            boolean isBookInCart = false;
            List<String> nameBooks = cart.getNameBooks();
            List<Float> costs = cart.getCostBooks();
            List<Integer> counts = cart.getCountBooks();
            int i = 0;
            while (!isBookInCart && i != nameBooks.size()) {
                if (nameBooks.get(i).equals(bookDto.getNameBook())) {
                    isBookInCart = true;
                } else {
                    i++;
                }
            }
            if (!isBookInCart) {
                nameBooks.add(bookDto.getNameBook());
                costs.add(bookDto.getCostBook());
                counts.add(count);
            } else {
                counts.set(i, counts.get(i) + count);
            }

            cart.setNameBooks(nameBooks);
            cart.setCostBooks(costs);
            cart.setCountBooks(counts);
            CartEntity cartEntity = cartMapperImpl.toEntity(cart);
            cartRepository.save(cartEntity);

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
     *
     * @return список корзин
     */
    public List<CartDto> readAll() {
        Iterable<CartEntity> cartsIterable = cartRepository.findAll();
        List<CartEntity> carts = new ArrayList<>();
        cartsIterable.forEach(carts::add);
        return cartListMapper.toCartDtoList(carts);
    }
}
