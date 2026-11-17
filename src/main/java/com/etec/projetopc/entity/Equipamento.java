package com.etec.projetopc.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.GenerationType;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Equipamento {
    
@Id
@GeneratedValue(strategy = GenerationType.AUTO)

private Long id;
private String nome;
private String tipo;
private String marca;
private String modelo;
private String patrimonio;

}
