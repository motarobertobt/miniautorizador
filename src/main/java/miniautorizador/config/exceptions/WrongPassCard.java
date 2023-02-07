package miniautorizador.config.exceptions;

public class WrongPassCard extends RuntimeException {
    public WrongPassCard(String message){
        super(message);
    }

}
