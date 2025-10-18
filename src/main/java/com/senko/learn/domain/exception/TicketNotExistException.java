package com.senko.learn.domain.exception;

public class TicketNotExistException extends RuntimeException{
    public TicketNotExistException(String message){
        super(message);
    }
}
