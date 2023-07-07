package ru.pet.api_test4.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.pet.api_test4.dto.NotFoundException;

@ControllerAdvice
public class ExceptionController {
    /*@ExceptionHandler(Exception.class)
    public ResponseEntity<NotFoundException> notFoundException(Exception exception) {
        NotFoundException excep = new NotFoundException();
        excep.setCode(404);
        excep.setMessage("Запись не найдена");
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(excep);
    }*/
}
