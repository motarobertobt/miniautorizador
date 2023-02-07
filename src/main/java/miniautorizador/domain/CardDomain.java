package miniautorizador.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class CardDomain {
    private int id;
    private String numeroCartao;
    private String senha;
    private double balance;    
    private Date createdAt;    
}
