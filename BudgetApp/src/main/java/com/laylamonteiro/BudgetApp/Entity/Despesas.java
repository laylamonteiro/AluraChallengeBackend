package com.laylamonteiro.BudgetApp.Entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Despesas {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String descricao;

    @Column
    private Double valor;

    @Column
    private LocalDate data;
}
