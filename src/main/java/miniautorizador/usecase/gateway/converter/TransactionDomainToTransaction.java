package miniautorizador.usecase.gateway.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import miniautorizador.domain.TransactionDomain;
import miniautorizador.repository.model.Transaction;

@Component
@AllArgsConstructor
public class TransactionDomainToTransaction {
    private final ModelMapper modelMapper;

    public Transaction convert(TransactionDomain transaction) {
        return modelMapper.map(transaction, Transaction.class);
    }

}
