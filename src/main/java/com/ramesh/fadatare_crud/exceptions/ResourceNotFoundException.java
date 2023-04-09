package com.ramesh.fadatare_crud.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    private String resourceName;
    private String fieldName;
    private Long value;

    public ResourceNotFoundException( String resourceName, String fieldName, Long value) {
        super(String.format("%s is not found with %s : %s",resourceName,fieldName,value));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.value = value;
    }
}
