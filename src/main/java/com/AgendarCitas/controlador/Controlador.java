package com.AgendarCitas.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import com.AgendarCitas.modelo.Paciente;
import com.AgendarCitas.servicios.PacienteServicio;


//@Controller
@RestController
@RequestMapping("/api/pacientes")


public class Controlador {
	
	@Autowired
	private PacienteServicio pacienteServicio;

	
	
	
	@GetMapping("/listar")
    public List<Paciente> listarPacientes() {
        return pacienteServicio.listarPacientes();
    }
	
	@PostMapping("/agregar")
    public Paciente guardarPaciente(@RequestBody Paciente paciente) {
        return pacienteServicio.guardarPaciente(paciente);
    }
	
	@DeleteMapping("/{id}")
    public void eliminarPaciente(@PathVariable int id) {
        pacienteServicio.eliminarPaciente(id);
        
    }

    @GetMapping("/{id}")
    public Paciente obtenerPacientePorId(@PathVariable int id) {
        return pacienteServicio.obtenerPacientePorId(id);
    }
    
    @PutMapping("/actualizar/{id}")
    public Paciente actualizarPaciente(@PathVariable int id, @RequestBody Paciente pacienteDetalles) {
        return pacienteServicio.actualizarPaciente(id, pacienteDetalles);
    }
	
	
	
	

}
