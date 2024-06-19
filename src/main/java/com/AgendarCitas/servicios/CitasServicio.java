package com.AgendarCitas.servicios;

import java.util.List;
//import java.util.Optional;

//import javax.print.attribute.standard.Media;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AgendarCitas.interfaces.ICitas;
import com.AgendarCitas.interfaces.IMedico;
import com.AgendarCitas.interfaces.IPaciente;
import com.AgendarCitas.modelo.Citas;
import com.AgendarCitas.modelo.Medico;
import com.AgendarCitas.modelo.Paciente;

@Service
public class CitasServicio {
	
	@Autowired
	private ICitas citasRepository;
	@Autowired
	private IPaciente pacienteRepository;
	@Autowired
	private IMedico medicoRepository;

	public List<Citas> listarCitas() {
		// TODO Auto-generated method stub
		return citasRepository.findAll();
	}

	public Citas guardarCitas(Citas citas) {
		// TODO Auto-generated method stub
		
		return citasRepository.save(citas);
	}
	public Citas agendarCita(int medicoId, int pacienteId, Citas citaDetalles) {
        Medico medico = medicoRepository.findById(medicoId).orElseThrow(() -> new RuntimeException("Medico no encontrado"));
        Paciente paciente = pacienteRepository.findById(pacienteId).orElseThrow(() -> new RuntimeException("Paciente no encontrado"));
        citaDetalles.setMedico(medico);
        citaDetalles.setPaciente(paciente);
        
        return citasRepository.save(citaDetalles);
    }

	public void eliminarCitas(int id) {
		// TODO Auto-generated method stub
		citasRepository.deleteById(id);
	}

	public Citas obtenerCitasPorId(int id) {
		// TODO Auto-generated method stub
		return citasRepository.findById(id).orElse(null);
	}

	public Citas actualizarCita(int id, Citas citaDetalles) {
        Citas citaExistente = citasRepository.findById(id).orElseThrow(() -> new RuntimeException("Cita no encontrada"));
        citaExistente.setFechaHora(citaDetalles.getFechaHora());
        citaExistente.setDescripcion(citaDetalles.getDescripcion());
        citaExistente.setPaciente(citaDetalles.getPaciente());
        citaExistente.setMedico(citaDetalles.getMedico());
        return citasRepository.save(citaExistente);
    }
	
	public Citas actualizarMedicoEnCita(int citaId, int nuevoMedicoId) {
        Citas citaExistente = citasRepository.findById(citaId).orElseThrow(() -> new RuntimeException("Cita no encontrada"));
        Medico nuevoMedico = medicoRepository.findById(nuevoMedicoId).orElseThrow(() -> new RuntimeException("Nuevo médico no encontrado"));

        citaExistente.setMedico(nuevoMedico);

        return citasRepository.save(citaExistente);
    }

    public void eliminarCita(int id) {
        citasRepository.deleteById(id);
    }

    public List<Citas> obtenerCitasPorMedico(Medico medico) {
        return citasRepository.findByMedico(medico);
    }

    public List<Citas> obtenerCitasPorPaciente(Paciente paciente) {
        return citasRepository.findByPaciente(paciente);
    }

    public List<Citas> obtenerCitasPorMedicoYPaciente(int medicoId, int pacienteId) {
        return citasRepository.findByMedicoAndPaciente(medicoId, pacienteId);
    }

    public List<Citas> obtenerCitasPorNombreMedico(String nombreMedico) {
        return citasRepository.findByNombreMedico(nombreMedico);
    }

    public List<Citas> obtenerCitasPorNombrePaciente(String nombrePaciente) {
        return citasRepository.findByNombrePaciente(nombrePaciente);
    }

    public Citas obtenerCitaPorId(int id) {
        return citasRepository.findById(id).orElseThrow(() -> new RuntimeException("Cita no encontrada"));
    }
}
