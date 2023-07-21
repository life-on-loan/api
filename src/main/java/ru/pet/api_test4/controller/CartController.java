package ru.pet.api_test4.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.pet.api_test4.dto.CartDto;
import ru.pet.api_test4.error.NotFoundException;
import ru.pet.api_test4.dto.OrderPositionDto;

import java.util.List;

@RequestMapping("/cart")
public interface CartController {
    @PostMapping
    ResponseEntity<?> create(@RequestBody CartDto cart) throws NotFoundException;

    @DeleteMapping("/{id_cart}")
    ResponseEntity<?> delete(@PathVariable(name = "id_cart") int id);

    @PutMapping("/{id_cart}")
    ResponseEntity<?> update(@PathVariable(name = "id_cart") int id, @RequestBody OrderPositionDto data) throws NotFoundException;

    @GetMapping
    ResponseEntity<List<CartDto>> read() throws NotFoundException;
}
