package com.example.santanderdevweek2023.model;

import com.example.santanderdevweek2023.model.enumerados.TipoCartao;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class CartaoCredito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bandeira;
    private String numero;

    @Enumerated(EnumType.STRING)
    private TipoCartao tipoCartao;

    @Column(precision = 13 , scale = 2)
    private BigDecimal limite;



}
