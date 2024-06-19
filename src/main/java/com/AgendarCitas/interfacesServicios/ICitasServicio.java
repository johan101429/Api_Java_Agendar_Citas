package com.AgendarCitas.interfacesServicios;


import java.util.List;
import java.util.Optional;

import com.AgendarCitas.modelo.Citas;

public interface ICitasServicio {
	public List<Citas>listar();
	public Optional<Citas>listarId(int id);
	public int save(Citas c);
	public void delete(int id);
	List<Citas>Listar();
}
