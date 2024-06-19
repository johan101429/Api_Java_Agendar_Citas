package com.AgendarCitas.interfaces;

import com.AgendarCitas.modelo.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMedico extends JpaRepository<Medico, Integer> {
}
