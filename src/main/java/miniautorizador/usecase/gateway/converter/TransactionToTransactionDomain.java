package miniautorizador.usecase.gateway.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import miniautorizador.domain.TransactionDomain;
import miniautorizador.repository.model.Transaction;

@Component
@AllArgsConstructor
public class TransactionToTransactionDomain {
    private final ModelMapper modelMapper;

    public TransactionDomain convert(Transaction transaction) {
        return modelMapper.map(transaction, TransactionDomain.class);
    }

}
