package com.laylamonteiro.BudgetApp.Controller;

import com.laylamonteiro.BudgetApp.DTO.DespesasDTO;
import com.laylamonteiro.BudgetApp.Entity.Despesas;
import com.laylamonteiro.BudgetApp.Service.DespesasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DespesasController {

    @Autowired
    DespesasService despesasService;

    @GetMapping("/despesas")
    @ResponseStatus(HttpStatus.OK)
    public List<Despesas> getAllDespesas() {
        return despesasService.findAll();
    }

    @GetMapping("/despesa/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Despesas getDespesaById(@PathVariable(name = "id") Long id) {
        return despesasService.findById(id);
    }

    @PostMapping("/despesa")
    @ResponseStatus(HttpStatus.CREATED)
    public Despesas createDespesa(@RequestBody DespesasDTO despesa) {
        return despesasService.create(despesa);
    }

    @PutMapping("/despesa")
    @ResponseStatus(HttpStatus.OK)
    public Despesas updateDespesa(@Valid @RequestBody Despesas despesa) {
        return despesasService.update(despesa);
    }

    @DeleteMapping("/despesa/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDespesa(@PathVariable(name = "id") Long id) {
        despesasService.delete(id);
    }
}
