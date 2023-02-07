package miniautorizador.usecase.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import miniautorizador.config.exceptions.NoOneCardFound;
import miniautorizador.usecase.CheckBalanceUseCase;
import miniautorizador.usecase.gateway.CardGateway;

@Service
@AllArgsConstructor
public class CheckBalanceUseCaseImpl implements CheckBalanceUseCase {

    private final CardGateway cardGateway;
    private static final String NAO_ENCONTRADO = "Cartão não encontrado";

    @Override
    public Double execute(String numeroCartao) throws NoOneCardFound {
        final var card = cardGateway.searchCard(numeroCartao);
        return Optional.ofNullable(card).map(cardMap -> cardMap.getBalance()).orElseThrow(()-> new NoOneCardFound(NAO_ENCONTRADO));
    }

}
