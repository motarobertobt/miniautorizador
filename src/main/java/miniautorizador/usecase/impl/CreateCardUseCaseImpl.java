package miniautorizador.usecase.impl;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import miniautorizador.domain.CardDomain;
import miniautorizador.domain.CreateCardsDomain;
import miniautorizador.usecase.CreateCardUseCase;
import miniautorizador.usecase.gateway.CardGateway;

@Service
@AllArgsConstructor
public class CreateCardUseCaseImpl implements CreateCardUseCase {

    private final CardGateway cardGateway;

    @Override
    public CardDomain execute(CreateCardsDomain cardData) throws Throwable {
        cardData.setBalance(500.00);
        return cardGateway.saveCard(cardData);
    }

}
