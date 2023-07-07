package ru.pet.api_test4.dto;

public class NotFoundException extends Exception{
    private String message;

    public NotFoundException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
