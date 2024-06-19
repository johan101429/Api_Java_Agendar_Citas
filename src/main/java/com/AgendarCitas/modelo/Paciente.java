package com.AgendarCitas.modelo;


import java.util.List;

//import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name= "Paciente")


public class Paciente {
	@Id
	@GeneratedValue( strategy =GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private String apellido;
	private String telefono;
	private String direccion;
	
	 @OneToMany(mappedBy = "paciente")
	// @JsonManagedReference
	    private List<Citas> citas;
	
	public Paciente () {
		
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public Paciente(int id, String nombre, String apellido, String telefono, String direccion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.direccion = direccion;
	}


	public List<Paciente> listarPacientes() {
		// TODO Auto-generated method stub
		return null;
	}
	
	//public List<Citas> getCitas() {
       // return citas;
    //}

    //public void setCitas(List<Citas> citas) {
       // this.citas = citas;
    //}

}
