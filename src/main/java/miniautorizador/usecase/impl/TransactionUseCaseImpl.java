package miniautorizador.usecase.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import miniautorizador.config.exceptions.NoOneCardFound;
import miniautorizador.config.exceptions.NotEnoughBalanceAccountException;
import miniautorizador.config.exceptions.WrongPassCard;
import miniautorizador.domain.AuthResponseDomain;
import miniautorizador.domain.CardDomain;
import miniautorizador.domain.StatusAuth;
import miniautorizador.domain.TransactionDomain;
import miniautorizador.usecase.TransactionUseCase;
import miniautorizador.usecase.gateway.AuthGateway;
import miniautorizador.usecase.gateway.CardGateway;

@Service
@AllArgsConstructor
public class TransactionUseCaseImpl implements TransactionUseCase {

    private static final String SEM_SALDO_SUFICIENTE = "Sem saldo suficiente";
    private static final String NAO_ENCONTRADO = "Cartão não encontrado";
    private static final String SENHA_INVALIDA = "Senha Invalida";
    private CardGateway cardGateway;
    private AuthGateway authGateway;

    @Override
    public AuthResponseDomain execute(TransactionDomain transaction) {
        try {
            CardDomain card = cardGateway.searchCard(transaction.getNumeroCartao());
            Optional.ofNullable(card).orElseThrow(() -> new NoOneCardFound(NAO_ENCONTRADO));
            Optional.ofNullable(card).map((cardMap)-> checkPass(cardMap.getSenha(), transaction.getSenha())).orElseThrow(() -> new WrongPassCard(SENHA_INVALIDA));
            Optional.ofNullable(card).map((cardMap) -> withDrawBalance(cardMap.getBalance(), transaction.getValor()))
                    .orElseThrow(() -> new NotEnoughBalanceAccountException(SEM_SALDO_SUFICIENTE));
            final var newCard = setNewBalance(card, transaction.getValor());
            cardGateway.updateCard(newCard);
            authGateway.saveTransaction(transaction);
            return AuthResponseDomain.builder().status(201).message(StatusAuth.OK).build();
        } catch (NoOneCardFound e) {            
            return AuthResponseDomain.builder().status(422).message(StatusAuth.CARTAO_INEXISTENTE).build();
        } catch (NotEnoughBalanceAccountException e) {
            return AuthResponseDomain.builder().status(422).message(StatusAuth.SALDO_INSUFICIENTE).build();
        } catch(WrongPassCard e){
            return AuthResponseDomain.builder().status(422).message(StatusAuth.SENHA_INVALIDA).build();
        }
    }

    private Boolean checkPass(String cardPass, String informedPass) {
        return cardPass.equals(informedPass) ? true : null;
    }

    private Double withDrawBalance(Double balance, Double discount) {
        return balance > discount ? balance - discount : null;
    }

    private CardDomain setNewBalance(CardDomain cardDomain, Double withDraw) {
        return CardDomain.builder().balance(withDrawBalance(cardDomain.getBalance(), withDraw))
                .numeroCartao(cardDomain.getNumeroCartao()).senha(cardDomain.getSenha()).id(cardDomain.getId()).build();
    }
}
