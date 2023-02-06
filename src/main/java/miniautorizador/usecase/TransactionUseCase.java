package miniautorizador.usecase;

import miniautorizador.domain.TransactionDomain;

public interface TransactionUseCase {
    TransactionDomain execute(TransactionDomain transaction);
}
