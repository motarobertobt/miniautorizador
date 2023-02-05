package miniautorizador.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
public class CreateCardsDomain {
    private int cardNumber;
    private String password;

}
