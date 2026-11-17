package com.etec.projetopc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.etec.projetopc.entity.Tecnico;
import com.etec.projetopc.repository.TecnicoRepository;

@Service
public class TecnicoService {

    private final TecnicoRepository tecnicoRepository;

    public TecnicoService(TecnicoRepository tecnicoRepository) {
        this.tecnicoRepository = tecnicoRepository;
    }

    public void salvar(Tecnico tecnico) {
        tecnicoRepository.save(tecnico);
    }

    public Optional<Tecnico> buscarPorId(Long id) {
        return tecnicoRepository.findById(id);
    }

    public List<Tecnico> listarTodos() {
        return tecnicoRepository.findAll();
    }

    public void excluir(Long id) {
        tecnicoRepository.deleteById(id);
    }
}