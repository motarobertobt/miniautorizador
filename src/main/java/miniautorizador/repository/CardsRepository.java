package miniautorizador.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import miniautorizador.repository.model.Card;

public interface CardsRepository extends JpaRepository<Card, Long> {
    Card findBynumeroCartao(String numeroCartao);
}
