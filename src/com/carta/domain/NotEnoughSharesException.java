package com.carta.domain;

public class NotEnoughSharesException extends Exception {
    public NotEnoughSharesException(String message) {
        super(message);
    }
}
