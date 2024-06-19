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
@Table(name="Medico")


public class Medico {

	@Id
	@GeneratedValue (strategy =GenerationType.IDENTITY)
	
	private int id;
	private String nombre;
	private String apellido;
	private String telefono;
	private String especializacion;
	
	@OneToMany(mappedBy = "medico")
	//@JsonManagedReference
    private List<Citas> citas;

	
	
	public Medico() {
		
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id =id;
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
		this.apellido=apellido;
	}
	
	public String getTelefono() {
		return telefono;
	}
	public void  setTelefono(String telefono) {
		this.telefono=telefono;
	}
	
	public String getEspecializacion() {
		return especializacion;
	}
	
	public void setEspecializacion(String especializacion) {
		this.especializacion= especializacion;
	}
	
	public Medico(int id,String nombre,String apellido, String telefono, String especializacion) {
		super();
		this.id =id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.especializacion =especializacion;
	}
	
	public List<Medico> listarMedico(){
		return null;
	}
	/*public List<Citas> getCitas() {
	        return citas;
	    }

	    public void setCitas(List<Citas> citas) {
	        this.citas = citas;
	    }*/
}
	
	
	


