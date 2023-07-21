package ru.pet.api_test4.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.pet.api_test4.error.NotFoundException;
import ru.pet.api_test4.dto.OrderPositionDto;
import ru.pet.api_test4.dto.CartDto;
import ru.pet.api_test4.service.CartService;

import java.util.List;

@RestController
public class CartControllerImpl implements CartController {

    private final CartService cartService;

    public CartControllerImpl(CartService cartService) {
        this.cartService = cartService;
    }

    @Override
    public ResponseEntity<?> create(@RequestBody CartDto cart) throws NotFoundException {
        cartService.create(cart);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> delete(@PathVariable(name = "id_cart") int id) {
        final boolean deleted = cartService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @Override
    public ResponseEntity<?> update(@PathVariable(name = "id_cart") int id, @RequestBody OrderPositionDto data) throws NotFoundException {
        final boolean updated = cartService.add(id, data);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @Override
    public ResponseEntity<List<CartDto>> read() throws NotFoundException {
        final List<CartDto> books = cartService.readAll();

        return books != null && !books.isEmpty()
                ? new ResponseEntity<>(books, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
