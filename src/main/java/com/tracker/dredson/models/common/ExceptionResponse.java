package com.tracker.dredson.models.common;

public class ExceptionResponse extends RuntimeException {
    public ExceptionResponse(String mensaje) {
        super(mensaje);
    }
}