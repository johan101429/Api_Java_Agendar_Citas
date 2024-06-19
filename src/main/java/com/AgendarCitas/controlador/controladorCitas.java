package com.AgendarCitas.controlador;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.AgendarCitas.modelo.Citas;
import com.AgendarCitas.modelo.Medico;
import com.AgendarCitas.modelo.Paciente;
import com.AgendarCitas.servicios.CitasServicio;

@RestController
@RequestMapping("/api/citas")

public class controladorCitas {
	
	@Autowired
	private CitasServicio citasServicio;
	
	
    @GetMapping("/listar")
    public List<Citas> listarCitas() {
        return citasServicio.listarCitas();
    }
    
    @GetMapping("/listarcitas/{id}")
    public Citas listarCitasId(@PathVariable int id) {
        return citasServicio.obtenerCitaPorId(id);
    }

    @PostMapping("/agregar")
    public Citas guardarCita(@RequestBody Citas cita) {
        return citasServicio.guardarCitas(cita);
    }
    @PostMapping("/agendar")
    public Citas agendarCita(@RequestParam int medicoId, @RequestParam int pacienteId, @RequestBody Citas citaDetalles) {
        return citasServicio.agendarCita(medicoId, pacienteId, citaDetalles);
    }

    @PutMapping("/actualizar/{id}")
    public Citas actualizarCita(@PathVariable  int id, @RequestBody Citas citaDetalles) {
        return citasServicio.actualizarCita(id, citaDetalles);
    }
    
    @PutMapping("/actualizarMedico/{citaId}")
    public Citas actualizarMedicoEnCita(@PathVariable int citaId, @RequestParam int nuevoMedicoId) {
        return citasServicio.actualizarMedicoEnCita(citaId, nuevoMedicoId);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarCita(@PathVariable int id) {
        citasServicio.eliminarCita(id);
    }

    @GetMapping("/medico/{medicoId}")
    public List<Citas> obtenerCitasPorMedico(@PathVariable int medicoId) {
        Medico medico = new Medico();
        medico.setId(medicoId);
        return citasServicio.obtenerCitasPorMedico(medico);
    }

    @GetMapping("/paciente/{pacienteId}")
    public List<Citas> obtenerCitasPorPaciente(@PathVariable int pacienteId) {
        Paciente paciente = new Paciente();
        paciente.setId(pacienteId);
        return citasServicio.obtenerCitasPorPaciente(paciente);
    }

    @GetMapping("/medico/{medicoId}/paciente/{pacienteId}")
    public List<Citas> obtenerCitasPorMedicoYPaciente(@PathVariable int medicoId, @PathVariable int pacienteId) {
        return citasServicio.obtenerCitasPorMedicoYPaciente(medicoId, pacienteId);
    }

    @GetMapping("/medico/nombre/{nombreMedico}")
    public List<Citas> obtenerCitasPorNombreMedico(@PathVariable String nombreMedico) {
        return citasServicio.obtenerCitasPorNombreMedico(nombreMedico);
    }

    @GetMapping("/paciente/nombre/{nombrePaciente}")
    public List<Citas> obtenerCitasPorNombrePaciente(@PathVariable String nombrePaciente) {
        return citasServicio.obtenerCitasPorNombrePaciente(nombrePaciente);
    }
}
