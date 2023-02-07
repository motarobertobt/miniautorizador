package miniautorizador.usecase.gateway.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import miniautorizador.domain.CardDomain;
import miniautorizador.repository.model.Card;

@Component
@AllArgsConstructor
public class CardsToCardDomain {

    private final ModelMapper modelMapper;

    public CardDomain convert(Card card) {
        return modelMapper.map(card, CardDomain.class);

    }
}
