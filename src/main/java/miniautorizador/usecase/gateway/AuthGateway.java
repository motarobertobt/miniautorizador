package miniautorizador.usecase.gateway;

import miniautorizador.domain.TransactionDomain;

public interface AuthGateway {

    TransactionDomain saveTransaction(TransactionDomain transaction);
    Double listTransaction();
    void updateTransaction();
}
