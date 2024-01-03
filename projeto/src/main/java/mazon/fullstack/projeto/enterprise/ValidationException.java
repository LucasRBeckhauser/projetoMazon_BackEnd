package mazon.fullstack.projeto.enterprise;

public class ValidationException extends RuntimeException{

    public ValidationException (String message) {
        super(message);
    }
}
