package com.ramesh.fadatare_crud.exceptions;

import java.time.LocalDateTime;

public class ResourceNotFoundResponse {
    private String message;
    private LocalDateTime errorTime;

    public ResourceNotFoundResponse(String message, LocalDateTime errorTime) {
        this.message = message;
        this.errorTime = errorTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getErrorTime() {
        return errorTime;
    }

    public void setErrorTime(LocalDateTime errorTime) {
        this.errorTime = errorTime;
    }
}
