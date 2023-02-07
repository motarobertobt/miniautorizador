package miniautorizador.usecase.gateway.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import miniautorizador.domain.CardDomain;
import miniautorizador.domain.CreateCardsDomain;
import miniautorizador.repository.CardsRepository;
import miniautorizador.usecase.gateway.CardGateway;
import miniautorizador.usecase.gateway.converter.CreateCardDomainToCards;
import miniautorizador.usecase.gateway.converter.CardDomainToCards;
import miniautorizador.usecase.gateway.converter.CardsToCardDomain;

@Service
@AllArgsConstructor
public class CardGatewayImpl implements CardGateway {
    
    private final CardsRepository cardsRepository;
    private final CardsToCardDomain cardsToCardDomain;
    private final CreateCardDomainToCards createCardDomainToCards;
    private final CardDomainToCards cardDomainToCards;

    @Override
    public CardDomain updateCard(CardDomain cardDomain) {
        final var card = cardDomainToCards.convert(cardDomain);
        final var createdCard = cardsRepository.save(card);
        return cardsToCardDomain.convert(createdCard);
    }

    @Override
    public CardDomain saveCard(CreateCardsDomain createCard) {
        final var card = createCardDomainToCards.convert(createCard);
        final var createdCard = cardsRepository.save(card);
        return cardsToCardDomain.convert(createdCard);
    }

    @Override
    public CardDomain searchCard(String numeroCartao) {
        final var card = cardsRepository.findBynumeroCartao(numeroCartao);
        return Optional.ofNullable(card).map(cardsToCardDomain::convert).orElseGet(() -> null);         
    }

}
