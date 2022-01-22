package com.laylamonteiro.BudgetApp.Service;

import com.laylamonteiro.BudgetApp.Entity.Receitas;
import com.laylamonteiro.BudgetApp.Repository.ReceitasRepository;
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
public class ReceitasService {

    @Autowired
    final ReceitasRepository repository;

    public List<Receitas> findAll() {
        return repository.findAll();
    }

    public Receitas findById(final Long id) {
        Optional<Receitas> receita = repository.findById(id);

        if (receita.isPresent()) {
            return receita.get();
        } else {
            throw new EntityNotFoundException("Receita " + id + "não encontrada.");
        }
    }

    public Receitas create(Receitas receita) {
        return repository.save(receita);
    }

    public Receitas update(Receitas incomingReceita) {
        Long incomingReceitaId = incomingReceita.getId();
        Optional<Receitas> existingReceita = repository.findById(incomingReceitaId);

        if (existingReceita.isPresent()) {
            Receitas receita = existingReceita.get();
            receita.setDescricao(incomingReceita.getDescricao());
            receita.setValor(incomingReceita.getValor());
            receita.setData(incomingReceita.getData());

            return repository.save(receita);
        } else {
            throw new EntityNotFoundException("Despesa " + incomingReceitaId + "não encontrada.");
        }
    }

    public void delete(Long id) {
        Receitas receita = findById(id);
        repository.delete(receita);
    }
}
