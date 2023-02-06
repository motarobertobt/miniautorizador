package miniautorizador.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import miniautorizador.repository.model.Cards;

public interface CardsRepository extends JpaRepository<Cards, Long> {
    
}
