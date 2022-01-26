package com.laylamonteiro.BudgetApp.Service;

import com.laylamonteiro.BudgetApp.DTO.ReceitaDTO;
import com.laylamonteiro.BudgetApp.Entity.Receita;
import com.laylamonteiro.BudgetApp.Repository.ReceitaRepository;
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
    final ReceitaRepository repository;

    final EntityMapper mapper = new EntityMapper();

    public List<Receita> findAll() {
        return repository.findAll();
    }

    public Receita findById(final Long id) {
        Optional<Receita> receitaOptional = repository.findById(id);

        if (receitaOptional.isPresent()) {
            return receitaOptional.get();
        } else {
            throw new EntityNotFoundException("Receita " + id + "não encontrada.");
        }
    }

    @Transactional
    public Receita create(ReceitaDTO dto) {
        Receita receita = mapper.toEntity(dto);
        return repository.save(receita);
    }

    @Transactional
    public Receita update(Receita incomingReceita) {
        Long incomingReceitaId = incomingReceita.getId();
        Optional<Receita> existingReceita = repository.findById(incomingReceitaId);

        if (existingReceita.isPresent()) {
            Receita receita = existingReceita.get();
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
        Receita receita = findById(id);
        repository.delete(receita);
    }
}
