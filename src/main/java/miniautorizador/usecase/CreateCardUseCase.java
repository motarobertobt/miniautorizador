package miniautorizador.usecase;

import miniautorizador.domain.CreateCardsDomain;

public interface CreateCardUseCase {
    CreateCardsDomain execute(CreateCardsDomain cardData);
}
