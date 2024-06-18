package DAO;

import java.util.List;

import model.Contacto;

public interface AgendaDAO {

	void agregarContacto(Contacto contacto);
	
	Contacto recuperarContacto(String email);
	
	Contacto recuperarContacto(int idContacto);
	
	void eliminarContacto(String email);
	
	void eliminarContacto(int idContacto);
	
	List<Contacto> devolverContactos();
	
	void actualizarContacto(Contacto contacto);
}
