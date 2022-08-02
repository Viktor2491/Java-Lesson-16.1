package ru.netology.tournament;

public class NotRegisteredException extends RuntimeException {
    NotRegisteredException(String msg) {
        super(msg);
    }
}
