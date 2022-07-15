package br.com.api.cabeleiro.ExceptionConfig;

import br.com.api.cabeleiro.ExceptionConfig.Exceptions.ConflictEmailAlreadyExist;
import br.com.api.cabeleiro.ExceptionConfig.Exceptions.FalhaAutenticacaoUsuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class CustomizedExceptionHandling extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ConflictEmailAlreadyExist.class)
    public ResponseEntity<Object> handleExceptionsCPFUnique(ConflictEmailAlreadyExist exception, WebRequest webRequest) {
        ExceptionResponse response = new ExceptionResponse();
        response.setDateTime(LocalDateTime.now());
        response.setMessage(String.format("Email %s already exist !", exception.getEmail()));
        response.setError("error client side");
        ResponseEntity<Object> entity = new ResponseEntity<>(response, HttpStatus.CONFLICT);
        return entity;
    }


    @ExceptionHandler(FalhaAutenticacaoUsuario.class)
    public ResponseEntity<Object> FalhaAutenticacaoUsuario(FalhaAutenticacaoUsuario exception, WebRequest webRequest) {
        ExceptionResponse response = new ExceptionResponse();
        response.setDateTime(LocalDateTime.now());
        response.setMessage(String.format(String.format("Erro: %s", exception.getMessage())));
        response.setError("error client side");
        ResponseEntity<Object> entity = new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
        return entity;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException ex){
        Map<String, String> errorMap = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errorMap.put(error.getField(), error.getDefaultMessage());
        });
        return errorMap;
    }

}
