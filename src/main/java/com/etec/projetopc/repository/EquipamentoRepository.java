package com.etec.projetopc.repository;

import com.etec.projetopc.entity.Equipamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipamentoRepository 
extends JpaRepository<Equipamento, Long> {
}
