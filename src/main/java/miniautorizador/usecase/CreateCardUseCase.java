package miniautorizador.usecase;

import miniautorizador.domain.CardDomain;
import miniautorizador.domain.CreateCardsDomain;

public interface CreateCardUseCase {
    CardDomain execute(CreateCardsDomain cardData) throws Throwable;
}
