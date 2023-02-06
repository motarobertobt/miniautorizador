package miniautorizador.usecase.impl;

import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

import miniautorizador.domain.TransactionDomain;
import miniautorizador.usecase.TransactionUseCase;

@Service
@AllArgsConstructor
public class TransactionUseCaseImpl implements TransactionUseCase {

    @Override
    public TransactionDomain execute(TransactionDomain transaction) {
        return transaction;

    }

}
