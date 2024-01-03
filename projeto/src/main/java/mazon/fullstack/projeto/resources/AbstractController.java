package mazon.fullstack.projeto.resources;

import mazon.fullstack.projeto.enterprise.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AbstractController {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        List<String> collect = ex.getBindingResult()
                .getAllErrors().stream()
                .map(p -> ((FieldError) p).getField() + " "
                        + p.getDefaultMessage())
                .collect(Collectors.toList());
        errors.put("erro", collect.toString());
        return errors;
    }


    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    //Trata e devolve o código 422, ou seja os erros de cliente.Entidade nao processada. Alugma informacao estpa invalida.
    @ExceptionHandler(ValidationException.class)
    public Map<String, String> handleValidationExceptions422(
            ValidationException ex) {
        Map<String, String> errors = new HashMap<>();
        errors.put("erro", ex.getMessage());
        return errors;
    }

}
