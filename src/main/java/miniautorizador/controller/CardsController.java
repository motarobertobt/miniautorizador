package miniautorizador.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;

import miniautorizador.controller.resource.CheckBalanceResponseResource;
import miniautorizador.controller.resource.CreateCardResponseResource;

@RestController
@AllArgsConstructor
@RequestMapping("/cartoes")
public class CardsController {


    @GetMapping("/{cardNumber}")
    public CheckBalanceResponseResource checkBalance(@PathVariable int cardNumber){
        return null;
    }

    @PostMapping()
    public CreateCardResponseResource createCard(int cardNumber){


        return null;
    }
    
    
}
