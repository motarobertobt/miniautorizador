package miniautorizador.controller.resource;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class CreateCardRequestResource {
    private String numeroCartao;
    private String senha;
}
