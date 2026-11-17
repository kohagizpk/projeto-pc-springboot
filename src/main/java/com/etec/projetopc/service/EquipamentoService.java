package com.etec.projetopc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.etec.projetopc.entity.Equipamento;
import com.etec.projetopc.repository.EquipamentoRepository;

@Service
public class EquipamentoService {
    
    private final EquipamentoRepository equipamentoRepository;

    public EquipamentoService(EquipamentoRepository equipamentoRepository){
        this.equipamentoRepository = equipamentoRepository;
    }

    public void salvar(Equipamento equipamento){
        equipamentoRepository.save(equipamento);
    }

    public Optional<Equipamento> buscarPorId(Long id){
        return equipamentoRepository.findById(id);
    }

    public List<Equipamento> listarTodos() {
        return equipamentoRepository.findAll();
    }

    public void excluir(Long id) {
        equipamentoRepository.deleteById(id);
    }

}
