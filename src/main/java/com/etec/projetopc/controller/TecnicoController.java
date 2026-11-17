package com.etec.projetopc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.etec.projetopc.entity.Tecnico;
import com.etec.projetopc.service.TecnicoService;

@Controller
@RequestMapping("/tecnico")
public class TecnicoController {

    private final TecnicoService tecnicoService;

    public TecnicoController(TecnicoService tecnicoService) {
        this.tecnicoService = tecnicoService;
    }

    // LISTAR
    @GetMapping
    public String listar(Model model) {
        model.addAttribute(
            "tecnicos",
            tecnicoService.listarTodos()
        );

        return "tecnico/lista";
    }

    // NOVO
    @GetMapping("/novo")
    public String novo(Model model) {

        model.addAttribute(
            "tecnico",
            new Tecnico()
        );

        return "tecnico/formulario";
    }

    // SALVAR
    @PostMapping("/salvar")
    public String salvar(Tecnico tecnico) {

        tecnicoService.salvar(tecnico);

        return "redirect:/tecnico";
    }

    // EDITAR
    @GetMapping("/editar/{id}")
    public String editar(
            @PathVariable Long id,
            Model model) {

        Tecnico tecnico = tecnicoService
                .buscarPorId(id)
                .orElseThrow(() ->
                    new IllegalArgumentException(
                        "Tecnico não encontrado: " + id
                    )
                );

        model.addAttribute(
            "tecnico",
            tecnico
        );

        return "tecnico/formulario";
    }

    // EXCLUIR
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {

        tecnicoService.excluir(id);

        return "redirect:/tecnico";
    }
}