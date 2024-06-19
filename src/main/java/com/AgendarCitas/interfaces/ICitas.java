package com.AgendarCitas.interfaces;

import java.util.List;

//import javax.print.attribute.standard.Media;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.AgendarCitas.modelo.Citas;
import com.AgendarCitas.modelo.Medico;
import com.AgendarCitas.modelo.Paciente;


@Repository
public interface ICitas extends JpaRepository<Citas, Integer> {
	
	List<Citas> findByMedico(Medico medico);

    List<Citas> findByPaciente(Paciente paciente);

    @Query("SELECT c FROM Citas c WHERE c.medico.id = :medicoId AND c.paciente.id = :pacienteId")
    List<Citas> findByMedicoAndPaciente(@Param("medicoId") int medicoId, @Param("pacienteId") int pacienteId);

    @Query("SELECT c FROM Citas c WHERE c.medico.nombre = :nombreMedico")
    List<Citas> findByNombreMedico(@Param("nombreMedico") String nombreMedico);

    @Query("SELECT c FROM Citas c WHERE c.paciente.nombre = :nombrePaciente")
    List<Citas> findByNombrePaciente(@Param("nombrePaciente") String nombrePaciente);
}

