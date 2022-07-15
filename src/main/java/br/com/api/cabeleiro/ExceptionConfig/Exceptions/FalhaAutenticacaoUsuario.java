package br.com.api.cabeleiro.ExceptionConfig.Exceptions;

public class FalhaAutenticacaoUsuario extends RuntimeException {

    private String message;

    public FalhaAutenticacaoUsuario(String Message){
        this.message = Message;
    }

    public String getMessage() {
        return message;
    }

}
