package com.laylamonteiro.BudgetApp.Utils;

import com.laylamonteiro.BudgetApp.DTO.DespesasDTO;
import com.laylamonteiro.BudgetApp.DTO.ReceitasDTO;
import com.laylamonteiro.BudgetApp.Entity.Despesas;
import com.laylamonteiro.BudgetApp.Entity.Receitas;

public class EntityMapper {

    public DespesasDTO toDTO(Despesas despesa) {
        DespesasDTO dto = new DespesasDTO();

        dto.setId(despesa.getId());
        dto.setDescricao(despesa.getDescricao());
        dto.setValor(despesa.getValor());
        dto.setData(despesa.getData());

        return dto;
    }

    public ReceitasDTO toDTO(Receitas receita) {
        ReceitasDTO dto = new ReceitasDTO();

        dto.setId(receita.getId());
        dto.setDescricao(receita.getDescricao());
        dto.setValor(receita.getValor());
        dto.setData(receita.getData());

        return dto;
    }

    public Despesas toEntity(DespesasDTO dto) {
        Despesas despesa = new Despesas();

        despesa.setDescricao(dto.getDescricao());
        despesa.setValor(dto.getValor());
        despesa.setData(dto.getData());

        return despesa;
    }

    public Receitas toEntity(ReceitasDTO dto) {
        Receitas receita = new Receitas();

        receita.setDescricao(dto.getDescricao());
        receita.setValor(dto.getValor());
        receita.setData(dto.getData());

        return receita;
    }
}
