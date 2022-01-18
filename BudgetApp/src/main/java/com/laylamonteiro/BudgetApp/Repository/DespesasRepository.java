package com.laylamonteiro.BudgetApp.Repository;

import com.laylamonteiro.BudgetApp.Entity.Despesas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DespesasRepository extends JpaRepository<Despesas, Long> {
}
