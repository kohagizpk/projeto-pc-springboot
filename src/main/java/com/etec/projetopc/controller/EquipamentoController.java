package com.etec.projetopc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.etec.projetopc.entity.Equipamento;
import com.etec.projetopc.service.EquipamentoService;




@Controller
@RequestMapping("/equipamentos")
public class EquipamentoController {
    
    private final EquipamentoService equipamentoService;

    public EquipamentoController(EquipamentoService equipamentoService){
        this.equipamentoService = equipamentoService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute(
            "equipamentos",
            equipamentoService.listarTodos()
        );
        return "equipamento/lista";
    }
    

    @GetMapping("/novo") 
    public String novo(Model model){
        model.addAttribute("equipamento", new Equipamento());
        return "equipamento/formulario";
    }

    @PostMapping("/salvar")
    public String salvar(Equipamento equipamento){
        equipamentoService.salvar(equipamento);

        return "redirect:/equipamentos/novo";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Equipamento equipamento = equipamentoService.buscarPorId(id)
        .orElseThrow(() -> new IllegalArgumentException(
            "Equipamento não encontrado: " + id
        ));
        model.addAttribute("equipamento", equipamento);
        return "equipamento/formulario";
    }
    

}
