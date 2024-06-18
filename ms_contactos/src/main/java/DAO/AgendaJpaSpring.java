package DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import jakarta.transaction.Transactional;
import model.Contacto;

public interface AgendaJpaSpring extends JpaRepository<Contacto, Integer> {

	Contacto findByEmail(String email); // Devolveremos un Contacto a partir de un email

	// Como vamos a realizar un cambio en la capa de persistencia, tiene que ir con
	// Modifying y Transactional
	@Transactional
	@Modifying
	@Query("Delete FROM Contacto c WHERE c.email= ?1 ")
	void eliminarPorEmail(String email);

}
