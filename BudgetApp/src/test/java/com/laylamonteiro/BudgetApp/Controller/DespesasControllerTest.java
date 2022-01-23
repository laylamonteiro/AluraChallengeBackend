package com.laylamonteiro.BudgetApp.Controller;

import com.laylamonteiro.BudgetApp.Entity.Despesas;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestComponent;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestComponent
class DespesasControllerTest {

    @Autowired
    DespesasController despesasController = new DespesasController();

    @Test
    void getAllDespesas() {
        Despesas despesa1 = new Despesas(1L, "Despesa1", 10.0, LocalDate.now());
        Despesas despesa2 = new Despesas(2L, "Despesa2", 10.0, LocalDate.now());
        Despesas despesa3 = new Despesas(3L, "Despesa3", 10.0, LocalDate.now());
        Despesas despesa5 = new Despesas(4L, "Despesa4", 10.0, LocalDate.now());

        List<Despesas> despesas = Arrays.asList(despesa1, despesa2, despesa3, despesa5);

        List<Despesas> allDespesas = despesasController.getAllDespesas();

        assertSame(despesas, allDespesas);
    }

    @Test
    void getDespesaById() {
    }

    @Test
    void createDespesa() {
    }

    @Test
    void updateDespesa() {
    }

    @Test
    void deleteDespesa() {
    }
}