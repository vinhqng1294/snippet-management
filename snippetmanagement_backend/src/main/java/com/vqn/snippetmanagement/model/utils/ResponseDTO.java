package com.vqn.snippetmanagement.model.utils;

import org.springframework.http.ResponseEntity;

import java.util.Optional;

public class ResponseDTO {
    public ResponseDTO() {
    }

    public <T> T ok(Optional<T> object) {
        return (T) ResponseEntity.ok(object);
    }

    public <T> T invalid() {
        return (T) ResponseEntity.badRequest().build();
    }

    public <T> T notFound() {
        return (T) ResponseEntity.notFound().build();
    }
}
