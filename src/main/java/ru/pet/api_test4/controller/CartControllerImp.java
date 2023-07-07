package ru.pet.api_test4.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.pet.api_test4.dto.NotFoundException;
import ru.pet.api_test4.dto.OrderPosition;
import ru.pet.api_test4.dto.CartDto;
import ru.pet.api_test4.service.CartService;

import java.util.List;

//@Validated
@RestController
@RequestMapping("/cart")
public class CartControllerImp implements CartController{

    private final CartService cartService;

    @Autowired
    public CartControllerImp(CartService orderService) {
        this.cartService = orderService;
    }

    @Override
    @PostMapping
    public ResponseEntity<?> create(@RequestBody CartDto cart) {
        cartService.create(cart);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    @DeleteMapping("/{id_cart}")
    public ResponseEntity<?> delete(@PathVariable(name = "id_cart")int id) {
        final boolean deleted = cartService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @Override
    @PutMapping("/{id_cart}")
    public ResponseEntity<?> update(@PathVariable(name = "id_cart") int id, @RequestBody OrderPosition data) throws NotFoundException {
        Integer idBook = data.getIdBook();
        Integer count = data.getCount();
        final boolean updated = cartService.add(id, idBook, count);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<CartDto>> read() {
        final List<CartDto> books = cartService.readAll();

        return books != null && !books.isEmpty()
                ? new ResponseEntity<>(books, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
