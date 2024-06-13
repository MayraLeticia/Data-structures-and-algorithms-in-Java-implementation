package Services.Exceptions;

public class EmptyListException extends RuntimeException {

    public EmptyListException (String errorMensage){
        super(errorMensage);
    }
    
}
