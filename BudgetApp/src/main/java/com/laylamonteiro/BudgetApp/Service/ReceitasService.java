package com.laylamonteiro.BudgetApp.Service;

import com.laylamonteiro.BudgetApp.DTO.ReceitasDTO;
import com.laylamonteiro.BudgetApp.Entity.Receitas;
import com.laylamonteiro.BudgetApp.Repository.ReceitasRepository;
import com.laylamonteiro.BudgetApp.Utils.EntityMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Data
@Service
public class ReceitasService {

    @Autowired
    final ReceitasRepository repository;

    final EntityMapper mapper = new EntityMapper();

    public List<Receitas> findAll() {
        return repository.findAll();
    }

    public Receitas findById(final Long id) {
        Optional<Receitas> receitaOptional = repository.findById(id);

        if (receitaOptional.isPresent()) {
            return receitaOptional.get();
        } else {
            throw new EntityNotFoundException("Receita " + id + "não encontrada.");
        }
    }

    @Transactional
    public Receitas create(ReceitasDTO dto) {
        Receitas receita = mapper.toEntity(dto);
        return repository.save(receita);
    }

    @Transactional
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

    @Transactional
    public void delete(Long id) {
        Receitas receita = findById(id);
        repository.delete(receita);
    }
}
