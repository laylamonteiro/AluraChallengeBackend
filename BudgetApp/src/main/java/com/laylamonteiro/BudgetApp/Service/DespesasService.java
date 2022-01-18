package com.laylamonteiro.BudgetApp.Service;

import com.laylamonteiro.BudgetApp.Entity.Despesas;
import com.laylamonteiro.BudgetApp.Repository.DespesasRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Data
@Service
@Transactional
public class DespesasService {

    @Autowired
    final DespesasRepository repository;

    public List<Despesas> findAll() {
        return repository.findAll();
    }

    public Despesas findById(final Long id) {
        return repository.getById(id);
    }

    public Despesas create(Despesas despesa) {
        return repository.save(despesa);
    }

    public Despesas update(Despesas despesa) {
        return null;
    }

    public void delete(Long id) {
        return;
    }
}
