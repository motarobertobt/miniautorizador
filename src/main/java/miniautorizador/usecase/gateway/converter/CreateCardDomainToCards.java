package miniautorizador.usecase.gateway.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import miniautorizador.domain.CreateCardsDomain;
import miniautorizador.repository.model.Card;

@Component
@AllArgsConstructor
public class CreateCardDomainToCards {

    private final ModelMapper modelMapper;

    public Card convert(CreateCardsDomain card) {
        return modelMapper.map(card, Card.class);

    }
}
