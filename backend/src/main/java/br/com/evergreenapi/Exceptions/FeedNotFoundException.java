package br.com.evergreenapi.Exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Feed not found")
public class FeedNotFoundException extends RuntimeException{
    public FeedNotFoundException(Long id, String message) {
        super(message + id);
    }
}
 