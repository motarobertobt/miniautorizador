package miniautorizador.controller.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import miniautorizador.controller.resource.CreateCardRequestResource;
import miniautorizador.domain.CreateCardsDomain;

@Component
@AllArgsConstructor
public class CreateCardRequestResourceToCreateCardDomain {
    private final ModelMapper modelMapper;

    public CreateCardsDomain convert(CreateCardRequestResource createCard) {
        return modelMapper.map(createCard, CreateCardsDomain.class);

    }
}
