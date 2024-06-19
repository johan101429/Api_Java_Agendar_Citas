package com.AgendarCitas.interfaces;




import com.AgendarCitas.modelo.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPaciente extends JpaRepository<Paciente, Integer> {
}

