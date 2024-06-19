package com.AgendarCitas.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.AgendarCitas.modelo.Medico;
import com.AgendarCitas.servicios.MedicoServicio;

@RestController
@RequestMapping("/api/medico")

public class controladorMedico {
	
	
	@Autowired
	
	private MedicoServicio medicoServicio;
	
	@GetMapping("/listar")
	public  List<Medico> ListarMedico(){
		return medicoServicio.listarmedico();
	}
	
	@PostMapping("/agregar")
	public Medico guardarMedico(@RequestBody Medico medico) {
		return medicoServicio.guardarMedico(medico);
	}
	
	@DeleteMapping("/{id}")
	public void  eliminarMedico(@PathVariable int id) {
		medicoServicio.eliminarMedico(id);
	}
	
	@GetMapping("/{id}")
	public Medico obtenerMedicoPorId(@PathVariable int id) {
		return medicoServicio.obtenerMedicoPorId(id);
		
	}
	
	
	@PutMapping("/actualizar/{id}")
	public Medico actualizarMedico(@PathVariable int id ,@RequestBody Medico medicoDetalles) {
		return medicoServicio.actualizarMedico(id,medicoDetalles);
	}
	
	
	
}
	
	

