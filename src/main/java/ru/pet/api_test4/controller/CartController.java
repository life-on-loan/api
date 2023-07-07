package ru.pet.api_test4.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.pet.api_test4.dto.CartDto;
import ru.pet.api_test4.dto.NotFoundException;
import ru.pet.api_test4.dto.OrderPosition;

import java.util.List;

public interface CartController {
    ResponseEntity<?> create(@RequestBody CartDto cart);

    ResponseEntity<?> delete(@PathVariable(name = "id_cart") int id);

    ResponseEntity<?> update(@PathVariable(name = "id_cart") int id, @RequestBody OrderPosition data) throws NotFoundException;

    ResponseEntity<List<CartDto>> read();
}
