package miniautorizador.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
public class TransactionDomain {

    private int cardNumber;
    private String password;
    private double value;
    
}
