package miniautorizador.repository;

import javax.transaction.Transaction;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepository extends JpaRepository<Transaction, Long> {

}
