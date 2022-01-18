package com.laylamonteiro.BudgetApp.Repository;

import com.laylamonteiro.BudgetApp.Entity.Receitas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceitasRepository extends JpaRepository<Receitas, Long> {
}
