package miniautorizador.usecase.gateway;

import miniautorizador.domain.CardDomain;
import miniautorizador.domain.CreateCardsDomain;
import miniautorizador.repository.model.Card;

public interface CardGateway {
    CardDomain saveCard(CreateCardsDomain createCard);
    Card searchCard(String numeroCartao);
    void updateCard();
}
