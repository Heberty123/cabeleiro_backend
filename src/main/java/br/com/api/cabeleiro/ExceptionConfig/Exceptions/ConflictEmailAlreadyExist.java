package br.com.api.cabeleiro.ExceptionConfig.Exceptions;

public class ConflictEmailAlreadyExist extends RuntimeException{

    private String Email;
    public ConflictEmailAlreadyExist(String Email){
        this.Email = Email;
    }

    public String getEmail() {
        return Email;
    }
}
