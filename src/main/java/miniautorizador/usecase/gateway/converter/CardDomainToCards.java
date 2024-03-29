package miniautorizador.usecase.gateway.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import miniautorizador.domain.CardDomain;
import miniautorizador.repository.model.Card;

@Component
@AllArgsConstructor
public class CardDomainToCards {

    private final ModelMapper modelMapper;

    public Card convert(CardDomain card) {
        return modelMapper.map(card, Card.class);

    }
}
