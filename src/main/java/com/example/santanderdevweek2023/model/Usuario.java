package com.example.santanderdevweek2023.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @OneToMany( cascade = CascadeType.ALL)
    private List<CartaoCredito> cartoesCredito;

    @OneToMany( cascade = CascadeType.ALL)
    private List<ContaBancaria> contas;

    @OneToMany
    private List<Feature> features;



}
