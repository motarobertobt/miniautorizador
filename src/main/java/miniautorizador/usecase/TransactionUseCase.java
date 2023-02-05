package miniautorizador.usecase;

import miniautorizador.domain.TransactionDomain;

public interface TransactionUseCase {
    void execute(TransactionDomain transaction);
}
