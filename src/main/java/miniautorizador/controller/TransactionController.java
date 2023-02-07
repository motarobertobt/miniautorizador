package miniautorizador.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import lombok.AllArgsConstructor;
import miniautorizador.controller.converter.AuthRequestResourceToTransactionDomain;
import miniautorizador.controller.resource.AuthRequestResource;
import miniautorizador.usecase.TransactionUseCase;

@AllArgsConstructor
@RestController
@RequestMapping("/transacoes")
public class TransactionController {

    private final TransactionUseCase transactionUseCase;
    private final AuthRequestResourceToTransactionDomain authRequestResourceToTransactionDomain;

    @PostMapping()
    public ResponseEntity<String> transaction(@RequestBody AuthRequestResource authRequestResource) {
        final var transactionDomain = authRequestResourceToTransactionDomain.convert(authRequestResource);
        final var result = transactionUseCase.execute(transactionDomain);
        return ResponseEntity.status(result.getStatus()).body(result.getMessage().toString());
    }

}
