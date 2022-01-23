package com.laylamonteiro.BudgetApp.Service;

import com.laylamonteiro.BudgetApp.DTO.DespesasDTO;
import com.laylamonteiro.BudgetApp.Entity.Despesas;
import com.laylamonteiro.BudgetApp.Entity.Receitas;
import com.laylamonteiro.BudgetApp.Repository.DespesasRepository;
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
@Transactional
public class DespesasService {

    @Autowired
    final DespesasRepository repository;

    final EntityMapper mapper = new EntityMapper();


    public List<Despesas> findAll() {
        return repository.findAll();
    }

    public Despesas findById(final Long id) {
        Optional<Despesas> despesa = repository.findById(id);

        if (despesa.isPresent()) {
            return despesa.get();
        } else {
            throw new EntityNotFoundException("Despesa " + id + "não encontrada.");
        }
    }

    public Despesas create(DespesasDTO dto) {
        Despesas despesa = mapper.toEntity(dto);
        return repository.save(despesa);
    }

    public Despesas update(Despesas incomingDespesa) {
        Long incomingDespesaId = incomingDespesa.getId();
        Optional<Despesas> existingDespesa = repository.findById(incomingDespesaId);

        if (existingDespesa.isPresent()) {
            Despesas despesa = existingDespesa.get();
            despesa.setDescricao(incomingDespesa.getDescricao());
            despesa.setValor(incomingDespesa.getValor());
            despesa.setData(incomingDespesa.getData());

            return repository.save(despesa);
        } else {
            throw new EntityNotFoundException("Despesa " + incomingDespesaId + "não encontrada.");
        }
    }

    public void delete(Long id) {
        Despesas despesa = findById(id);
        repository.delete(despesa);
    }
}
