package miniautorizador.usecase.impl;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

import miniautorizador.domain.CreateCardsDomain;
import miniautorizador.usecase.CreateCardUseCase;

@Service
@AllArgsConstructor
public class CreateCardUseCaseImpl implements CreateCardUseCase {

    @Override
    public CreateCardsDomain execute(CreateCardsDomain cardData) {
        // TODO Auto-generated method stub
        return cardData;
    }

}
