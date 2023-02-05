package miniautorizador.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import miniautorizador.controller.resource.CreateCardResponseResource;

@RestController
@RequestMapping("/cartoes")
public class CardsController {


    @GetMapping("/{cardNumber}")
    public void checkBalance(@PathVariable int cardNumber){



    }

    @PostMapping()
    public CreateCardResponseResource createCard(int cardNumber){


        return null;
    }
    
    
}
