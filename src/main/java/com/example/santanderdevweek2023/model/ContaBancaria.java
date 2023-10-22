package com.example.santanderdevweek2023.model;

import com.example.santanderdevweek2023.model.enumerados.TipoConta;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class ContaBancaria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String agencia;
    private String numeroConta;
    @Enumerated(EnumType.STRING)
    private TipoConta tipoConta;

    @Column(precision = 13 , scale = 2)
    private BigDecimal saldo;

    @Column(precision = 13 , scale = 2)
    private BigDecimal limite;

}
