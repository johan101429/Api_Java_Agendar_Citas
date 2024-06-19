package com.AgendarCitas.modelo;

import java.time.LocalDateTime;

//import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Citas")

public class Citas {
	@Id
	@GeneratedValue (strategy =GenerationType.IDENTITY)
	
	private int id;
	private LocalDateTime fechaHora;
	private String descripcion;
	
	
	@ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
	//@JsonManagedReference
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "medico_id", nullable = false)
   // @JsonManagedReference
    private Medico medico;
	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /*public LocalDateTime getFechaHora1() {
        return fechaHora;
    }

    public void setFechaHora1(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }*/

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
    	this.descripcion=descripcion;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico2) {
        this.medico = medico2;
    }
	
	public LocalDateTime getFechaHora() {
		return fechaHora;
	}
	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}

	public void setNombre(Paciente paciente2) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	

}
