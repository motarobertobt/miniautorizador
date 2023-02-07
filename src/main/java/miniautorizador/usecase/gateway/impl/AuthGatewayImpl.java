package miniautorizador.usecase.gateway.impl;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import miniautorizador.domain.TransactionDomain;
import miniautorizador.repository.AuthRepository;
import miniautorizador.usecase.gateway.AuthGateway;
import miniautorizador.usecase.gateway.converter.TransactionDomainToTransaction;
import miniautorizador.usecase.gateway.converter.TransactionToTransactionDomain;


@Service
@AllArgsConstructor
public class AuthGatewayImpl implements AuthGateway {

    private final AuthRepository authRepository;
    private final TransactionDomainToTransaction transactionDomainToTransaction;
    private final TransactionToTransactionDomain transactionToTransactionDomain;
    

    @Override
    public TransactionDomain saveTransaction(TransactionDomain transaction) {              
        final var transactionModel = transactionDomainToTransaction.convert(transaction);
        final var saved = authRepository.save(transactionModel);
        return transactionToTransactionDomain.convert(saved);        
    }

    @Override
    public Double listTransaction() {
        return null;
        // TODO Auto-generated method stub

    }

    @Override
    public void updateTransaction() {
        // TODO Auto-generated method stub

    }

}
