package miniautorizador.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestBody;
import lombok.AllArgsConstructor;
import miniautorizador.config.exceptions.NoOneCardFound;
import miniautorizador.controller.converter.CardDomainToCreateCardResponseResource;
import miniautorizador.controller.converter.CreateCardRequestResourceToCreateCardDomain;
import miniautorizador.controller.resource.CreateCardRequestResource;
import miniautorizador.controller.resource.CreateCardResponseResource;
import miniautorizador.usecase.CreateCardUseCase;
import miniautorizador.usecase.impl.CheckBalanceUseCaseImpl;

@RestController
@AllArgsConstructor
@RequestMapping("/cartoes")
public class CardsController {

    private final CreateCardUseCase createCardUseCase;
    private final CreateCardRequestResourceToCreateCardDomain createCardRequestResourceToCreateCardDomain;
    private final CardDomainToCreateCardResponseResource cardDomainToCreateCardResponseResource;
    private final CheckBalanceUseCaseImpl checkBalanceUseCaseImpl;

    @GetMapping("/{numeroCartao}")
    public ResponseEntity<Double> checkBalance(@PathVariable String numeroCartao) {
        try {
            final var balance = checkBalanceUseCaseImpl.execute(numeroCartao);     
            return ResponseEntity.status(200).body(balance);       
        } catch (NoOneCardFound e) {
            return ResponseEntity.status(404).body(null);             
        }
    }

    @PostMapping
    public ResponseEntity<CreateCardResponseResource> createCard(
            @RequestBody(required = true) CreateCardRequestResource cardData) {
        try {
            final var cardDataDomain = createCardRequestResourceToCreateCardDomain.convert(cardData);
            final var result = createCardUseCase.execute(cardDataDomain);
            final var responseResult = cardDomainToCreateCardResponseResource.convert(result);
            return ResponseEntity.status(201).body(responseResult);
        } catch (Throwable e) {
            final var card = CreateCardResponseResource.builder().numeroCartao(cardData.getNumeroCartao()).senha(cardData.getSenha()).build();
            return ResponseEntity.status(422).body(card);
        }
    }

}
