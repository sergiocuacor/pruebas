package DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Contacto;

@Repository
public class AgendaDAOImpl implements AgendaDAO {

	@Autowired
	AgendaJpaSpring agenda; // Al inyectar esta clase que hereda de JpaRepository, podemos usar sus métodos
	
	@Override
	public void agregarContacto(Contacto contacto) {
		// TODO Auto-generated method stub
		agenda.save(contacto);
	}

	@Override
	public Contacto recuperarContacto(String email) {
		// TODO Auto-generated method stub
		return agenda.findByEmail(email);
	}

	@Override
	public Contacto recuperarContacto(int idContacto) {
		// TODO Auto-generated method stub
		return agenda.findById(idContacto).orElse(null);
	}

	@Override
	public void eliminarContacto(String email) {
		// TODO Auto-generated method stub
		agenda.eliminarPorEmail(email);
	}

	@Override
	public void eliminarContacto(int idContacto) {
		agenda.deleteById(idContacto);

	}

	@Override
	public List<Contacto> devolverContactos() {
		// TODO Auto-generated method stub
		return agenda.findAll();
	}

	@Override
	public void actualizarContacto(Contacto contacto) {
		agenda.save(contacto);

	}

}
