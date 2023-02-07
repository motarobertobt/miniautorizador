package miniautorizador.usecase;

import miniautorizador.domain.AuthResponseDomain;
import miniautorizador.domain.TransactionDomain;

public interface TransactionUseCase {
    AuthResponseDomain execute(TransactionDomain transaction);
}
