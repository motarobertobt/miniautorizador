package miniautorizador.controller.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import miniautorizador.controller.resource.AuthRequestResource;
import miniautorizador.domain.TransactionDomain;

@Component
@AllArgsConstructor
public class AuthRequestResourceToTransactionDomain {

    private final ModelMapper modelMapper;

    public TransactionDomain convert(AuthRequestResource authRequest) {
        return modelMapper.map(authRequest, TransactionDomain.class);

    }

}
