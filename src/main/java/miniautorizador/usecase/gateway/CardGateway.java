package miniautorizador.usecase.gateway;

import miniautorizador.domain.CardDomain;
import miniautorizador.domain.CreateCardsDomain;

public interface CardGateway {
    CardDomain saveCard(CreateCardsDomain createCard);
    CardDomain searchCard(String numeroCartao);
    CardDomain updateCard(CardDomain cardDomain);
}
