package com.AgendarCitas.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AgendarCitas.interfaces.IMedico;
import com.AgendarCitas.modelo.Medico;

@Service
public class MedicoServicio {
	
	@Autowired
	private IMedico medicoRepository;

	public List<Medico> listarmedico() {
		// TODO Auto-generated method stub
		return medicoRepository.findAll();
	}

	public Medico guardarMedico(Medico medico) {
		// TODO Auto-generated method stub
		return medicoRepository.save(medico);
	}

	public void eliminarMedico(int id) {
		medicoRepository.deleteById(id);
		
	}

	public Medico obtenerMedicoPorId(int id) {
		// TODO Auto-generated method stub
		return medicoRepository.findById(id).orElse(null);
	}

	public Medico actualizarMedico(int id, Medico medicoDetalles) {
		Optional<Medico> optionalMedico = medicoRepository.findById(id);
		if(optionalMedico.isPresent()) {
			Medico medicoExistente = optionalMedico.get();
			medicoExistente.setNombre(medicoDetalles.getNombre());
			medicoExistente.setApellido(medicoDetalles.getApellido());
			medicoExistente.setTelefono(medicoDetalles.getTelefono());
            medicoExistente.setEspecializacion(medicoDetalles.getEspecializacion());
            return medicoRepository.save(medicoExistente);
        } else {
			
        	return null;
		}
		
	}

	
	

}
