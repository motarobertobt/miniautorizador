package miniautorizador.controller.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import miniautorizador.controller.resource.CreateCardResponseResource;
import miniautorizador.domain.CardDomain;

@Component
@AllArgsConstructor
public class CardDomainToCreateCardResponseResource {
    private final ModelMapper modelMapper;

    public CreateCardResponseResource convert(CardDomain createCard) {
        return modelMapper.map(createCard, CreateCardResponseResource.class);

    }
}
