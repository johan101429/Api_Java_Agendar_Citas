package com.AgendarCitas.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AgendarCitas.interfaces.IPaciente;
import com.AgendarCitas.modelo.Paciente;

@Service
public class PacienteServicio  {

	@Autowired
	private IPaciente pacienteRepository;
	
	public List<Paciente> listarPacientes() {
		// TODO Auto-generated method stub
		return pacienteRepository.findAll();
	}

	

	public Paciente guardarPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}	

	 public void eliminarPaciente(int id) {
	        pacienteRepository.deleteById(id);
	    }
	

	 public Paciente obtenerPacientePorId(int id) {
	        return pacienteRepository.findById(id).orElse(null);
	    }
	 
	 public Paciente actualizarPaciente(int id, Paciente pacienteDetalles) {
	        Optional<Paciente> optionalPaciente = pacienteRepository.findById(id);
	        if (optionalPaciente.isPresent()) {
	            Paciente pacienteExistente = optionalPaciente.get();
	            pacienteExistente.setNombre(pacienteDetalles.getNombre());
	            pacienteExistente.setApellido(pacienteDetalles.getApellido());
	            pacienteExistente.setTelefono(pacienteDetalles.getTelefono());
	            pacienteExistente.setDireccion(pacienteDetalles.getDireccion());
	            return pacienteRepository.save(pacienteExistente);
	        } else {
	            return null;
	        }
	    }

	

}
