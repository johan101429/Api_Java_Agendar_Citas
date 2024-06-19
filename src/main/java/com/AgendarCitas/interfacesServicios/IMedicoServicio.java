package com.AgendarCitas.interfacesServicios;

import java.util.List;
import java.util.Optional;

import com.AgendarCitas.modelo.Medico;

public interface IMedicoServicio {
	
	public List<Medico>listar();
	public Optional<Medico>listarId(int id);
	public int save(Medico m);
	public void delete(int id);
	List<Medico>Listar();
	
	

}
