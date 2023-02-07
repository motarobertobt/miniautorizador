package miniautorizador.usecase.gateway.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import miniautorizador.domain.CardDomain;
import miniautorizador.domain.CreateCardsDomain;
import miniautorizador.repository.CardsRepository;
import miniautorizador.repository.model.Card;
import miniautorizador.usecase.gateway.CardGateway;
import miniautorizador.usecase.gateway.converter.CardDomainToCards;
import miniautorizador.usecase.gateway.converter.CardsToCardDomain;

@Service
@AllArgsConstructor
public class CardGatewayImpl implements CardGateway {
    @Autowired
    private final CardsRepository cardsRepository;
    private final CardsToCardDomain cardsToCardDomain;
    private final CardDomainToCards cardDomainToCards;

    @Override
    public void updateCard() {
        // TODO Auto-generated method stub

    }

    @Override
    public CardDomain saveCard(CreateCardsDomain createCard) {
        final var card = cardDomainToCards.convert(createCard);
        final var createdCard = cardsRepository.save(card);
        return cardsToCardDomain.convert(createdCard);
    }
 
    @Override
    public Card searchCard(String numeroCartao) {
        final var card = cardsRepository.findBynumeroCartao(numeroCartao);
        return card;
    }

}
