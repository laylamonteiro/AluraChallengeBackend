package com.laylamonteiro.BudgetApp.Service;

import com.laylamonteiro.BudgetApp.Entity.Despesas;
import com.laylamonteiro.BudgetApp.Repository.DespesasRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

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
        return repository.findById(id).get();
    }

    public Despesas create(Despesas despesa) {
        return repository.save(despesa);
    }

    public Despesas update(Despesas incomingDespesa) {
        Optional<Despesas> existingDespesa = repository.findById(incomingDespesa.getId());

        if (existingDespesa.isPresent()) {
            Despesas despesa = existingDespesa.get();
            despesa.setDescricao(incomingDespesa.getDescricao());
            despesa.setValor(incomingDespesa.getValor());
            despesa.setData(incomingDespesa.getData());

            return repository.save(despesa);
        } else {
            throw new EntityNotFoundException("Despesa não existe");
        }
    }

    public void delete(Long id) {
        Despesas despesa = findById(id);
        repository.delete(despesa);
    }
}
