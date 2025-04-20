package com.trachcode.dreamstore.exeption;

public class CategoryNotFoundException extends RuntimeException{
    public CategoryNotFoundException(String message) {
        super(message);
    }
}
