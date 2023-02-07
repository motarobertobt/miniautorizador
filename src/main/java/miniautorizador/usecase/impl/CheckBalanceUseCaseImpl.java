package miniautorizador.usecase.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import miniautorizador.usecase.CheckBalanceUseCase;
import miniautorizador.usecase.gateway.CardGateway;

@Service
@AllArgsConstructor
public class CheckBalanceUseCaseImpl implements CheckBalanceUseCase {

    private final CardGateway cardGateway;

    @Override
    public Double execute(String numeroCartao) {
        final var card = cardGateway.searchCard(numeroCartao);
        return Optional.ofNullable(card.getBalance()).orElseThrow(()-> new Error());
    }

}
