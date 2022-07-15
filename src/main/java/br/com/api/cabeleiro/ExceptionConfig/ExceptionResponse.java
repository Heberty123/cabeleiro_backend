package br.com.api.cabeleiro.ExceptionConfig;

import java.time.LocalDateTime;

public class ExceptionResponse {

    private String message;
    private LocalDateTime dateTime;
    private String error;

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public LocalDateTime getDateTime() { return dateTime; }
    public void setDateTime(LocalDateTime dateTime) { this.dateTime = dateTime; }

    public String getError() { return error; }

    public void setError(String error) { this.error = error; }
}
