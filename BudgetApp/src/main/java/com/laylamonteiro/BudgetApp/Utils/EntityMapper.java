package com.laylamonteiro.BudgetApp.Utils;

import com.laylamonteiro.BudgetApp.DTO.DespesaDTO;
import com.laylamonteiro.BudgetApp.DTO.ReceitaDTO;
import com.laylamonteiro.BudgetApp.Entity.Despesa;
import com.laylamonteiro.BudgetApp.Entity.Receita;

public class EntityMapper {

    public DespesaDTO toDTO(Despesa despesa) {
        DespesaDTO dto = new DespesaDTO();

        dto.setId(despesa.getId());
        dto.setDescricao(despesa.getDescricao());
        dto.setValor(despesa.getValor());
        dto.setData(despesa.getData());

        return dto;
    }

    public ReceitaDTO toDTO(Receita receita) {
        ReceitaDTO dto = new ReceitaDTO();

        dto.setId(receita.getId());
        dto.setDescricao(receita.getDescricao());
        dto.setValor(receita.getValor());
        dto.setData(receita.getData());

        return dto;
    }

    public Despesa toEntity(DespesaDTO dto) {
        Despesa despesa = new Despesa();

        despesa.setDescricao(dto.getDescricao());
        despesa.setValor(dto.getValor());
        despesa.setData(dto.getData());

        return despesa;
    }

    public Receita toEntity(ReceitaDTO dto) {
        Receita receita = new Receita();

        receita.setDescricao(dto.getDescricao());
        receita.setValor(dto.getValor());
        receita.setData(dto.getData());

        return receita;
    }
}
