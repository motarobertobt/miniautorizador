package miniautorizador.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import miniautorizador.repository.model.Transaction;

public interface AuthRepository extends JpaRepository<Transaction, Long> {

}
