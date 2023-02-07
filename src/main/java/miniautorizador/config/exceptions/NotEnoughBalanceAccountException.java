package miniautorizador.config.exceptions;

public class NotEnoughBalanceAccountException extends RuntimeException  {
    public NotEnoughBalanceAccountException(String message){
        super(message);
    }

}
