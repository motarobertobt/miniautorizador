package miniautorizador.controller;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import miniautorizador.controller.resource.CreateCardRequestResource;
import miniautorizador.domain.CardDomain;
import miniautorizador.usecase.impl.CheckBalanceUseCaseImpl;
import miniautorizador.usecase.impl.CreateCardUseCaseImpl;

@RunWith(MockitoJUnitRunner.class)
public class CardControllerTest {

    @InjectMocks
    private CardsController cardsController;

    @Mock
    private CheckBalanceUseCaseImpl checkBalanceUseCaseImpl;

    @Mock
    private CreateCardUseCaseImpl createCardUseCaseImpl;
    
    @Test
    public void testShouldGetCardBalance(){
        String numeroCartao = "6549873025634504";
        Double balance = (double) 300;

        when(checkBalanceUseCaseImpl.execute(anyString())).thenReturn(balance);

        var result = cardsController.checkBalance(numeroCartao);
        assertNotNull(result);

    }

    @Test
    public void testShouldCreateCard() throws Throwable{
        var cardData =  CreateCardRequestResource.builder().numeroCartao("6549873025634504").senha("1234").build();
        var cardCreated =  CardDomain.builder().numeroCartao("6549873025634504").senha("1234").build();

        when(createCardUseCaseImpl.execute(any())).thenReturn(cardCreated);

        var result = cardsController.createCard(cardData);
        assertNotNull(result);

    }
}
