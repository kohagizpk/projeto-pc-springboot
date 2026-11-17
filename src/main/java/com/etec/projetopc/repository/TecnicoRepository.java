package com.etec.projetopc.repository;
import com.etec.projetopc.entity.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TecnicoRepository 
extends JpaRepository<Tecnico, Long> {
}
