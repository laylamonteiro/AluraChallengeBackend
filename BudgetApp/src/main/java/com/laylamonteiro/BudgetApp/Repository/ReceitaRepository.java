package com.laylamonteiro.BudgetApp.Repository;

import com.laylamonteiro.BudgetApp.Entity.Receita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Long> {
}
