package miniautorizador.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


import miniautorizador.controller.converter.AuthRequestResourceToTransactionDomain;
import miniautorizador.controller.resource.AuthRequestResource;
import miniautorizador.domain.AuthResponseDomain;
import miniautorizador.domain.StatusAuth;
import miniautorizador.usecase.TransactionUseCase;

@RunWith(MockitoJUnitRunner.class)
public class TransactionControllerTest {

    @InjectMocks
    private TransactionController transactionController;    

    @Mock
    private TransactionUseCase transactionUseCase;

    @Mock
    private AuthRequestResourceToTransactionDomain authRequestResourceToTransactionDomain;

    @Test
    public void testShouldApproveTransaction() {
        var authRequestResource = AuthRequestResource.builder().numeroCartao("6549873025634504").senha("6549873025634504").valor((double) 100).build();

        var authResponseDomain = AuthResponseDomain.builder().status(200).message(StatusAuth.OK).build();
        when(transactionUseCase.execute(any())).thenReturn(authResponseDomain);
        var result = transactionController.transaction(authRequestResource);

        assertEquals(200, result.getStatusCode().value());
        assertEquals(StatusAuth.OK.toString(), result.getBody());

    }
    

    @Test
    public void testShouldntApproveTransaction() {
        var authRequestResource = AuthRequestResource.builder().numeroCartao("6549873025634504").senha("6549873025634504").valor((double) 600).build();

        var authResponseDomain = AuthResponseDomain.builder().status(422).message(StatusAuth.SALDO_INSUFICIENTE).build();
        when(transactionUseCase.execute(any())).thenReturn(authResponseDomain);
        var result = transactionController.transaction(authRequestResource);

        assertEquals(422, result.getStatusCode().value());
        assertEquals(StatusAuth.SALDO_INSUFICIENTE.toString(), result.getBody());

    }

}
