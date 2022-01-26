package com.laylamonteiro.BudgetApp.Service;

import com.laylamonteiro.BudgetApp.DTO.DespesaDTO;
import com.laylamonteiro.BudgetApp.Entity.Despesa;
import com.laylamonteiro.BudgetApp.Repository.DespesaRepository;
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
public class DespesasService {

    @Autowired
    final DespesaRepository repository;

    final EntityMapper mapper = new EntityMapper();


    public List<Despesa> findAll() {
        return repository.findAll();
    }

    public Despesa findById(final Long id) {
        Optional<Despesa> despesa = repository.findById(id);

        if (despesa.isPresent()) {
            return despesa.get();
        } else {
            throw new EntityNotFoundException("Despesa " + id + "não encontrada.");
        }
    }

    @Transactional
    public Despesa create(DespesaDTO dto) {
        Despesa despesa = mapper.toEntity(dto);
        return repository.save(despesa);
    }

    @Transactional
    public Despesa update(Despesa incomingDespesa) {
        Long incomingDespesaId = incomingDespesa.getId();
        Optional<Despesa> existingDespesa = repository.findById(incomingDespesaId);

        if (existingDespesa.isPresent()) {
            Despesa despesa = existingDespesa.get();
            despesa.setDescricao(incomingDespesa.getDescricao());
            despesa.setValor(incomingDespesa.getValor());
            despesa.setData(incomingDespesa.getData());

            return repository.save(despesa);
        } else {
            throw new EntityNotFoundException("Despesa " + incomingDespesaId + "não encontrada.");
        }
    }

    @Transactional
    public void delete(Long id) {
        Despesa despesa = findById(id);
        repository.delete(despesa);
    }
}
