package com.laylamonteiro.BudgetApp.Repository;

import com.laylamonteiro.BudgetApp.Entity.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DespesaRepository extends JpaRepository<Despesa, Long> {
}
