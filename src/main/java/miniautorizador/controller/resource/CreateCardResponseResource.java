package miniautorizador.controller.resource;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
public class CreateCardResponseResource {
    private int cardNumber;
    private String password;
}
