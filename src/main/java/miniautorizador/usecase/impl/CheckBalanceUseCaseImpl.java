package miniautorizador.usecase.impl;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import miniautorizador.usecase.CheckBalanceUseCase;

@Service
@AllArgsConstructor
public class CheckBalanceUseCaseImpl implements CheckBalanceUseCase{

    @Override
    public double execute(int cardNumber) {
        // TODO Auto-generated method stub
        return 0;
    }
    
}
