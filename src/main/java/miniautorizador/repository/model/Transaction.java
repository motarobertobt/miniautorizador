package miniautorizador.repository.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Entity
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private int cardNumber;
    private double value;
    private Date dateTransaction;
}
