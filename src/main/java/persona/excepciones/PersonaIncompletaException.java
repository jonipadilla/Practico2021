package persona.excepciones;

public class PersonaIncompletaException extends RuntimeException{
    public PersonaIncompletaException(String message) {
        super(message);
    }
}
