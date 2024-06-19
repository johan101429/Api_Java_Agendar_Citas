package com.AgendarCitas.interfacesServicios;

import java.util.List;
import java.util.Optional;

import com.AgendarCitas.modelo.Paciente;

public interface IPacienteServicio {
	public List<Paciente>listar();
	public Optional<Paciente>listarId(int id);
	public int save(Paciente p);
	public void delete(int id);
	List<Paciente> Listar();

}
