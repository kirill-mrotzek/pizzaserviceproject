package org.telran.pizzaservice.de.handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.telran.pizzaservice.de.exception.PizzaNotFoundException;
import org.telran.pizzaservice.de.exception.PizzeriaNotFoundException;
import org.telran.pizzaservice.de.exception.UserNotFoundException;
import org.telran.pizzaservice.de.exception.WalletNotFoundException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({UserNotFoundException.class,
            PizzaNotFoundException.class,
            PizzeriaNotFoundException.class,
    WalletNotFoundException.class})
    public ResponseEntity<Object> handleNotFoundException(Exception exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        Map<String, String> errorMap = new HashMap<>();
        List<ObjectError> allErrors = ex.getBindingResult().getAllErrors();
        for (ObjectError error : allErrors) {
            String field = ((FieldError) error).getField();
            String defaultMessage = error.getDefaultMessage();
            errorMap.put(field, defaultMessage);
        }
        return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
    }
}
