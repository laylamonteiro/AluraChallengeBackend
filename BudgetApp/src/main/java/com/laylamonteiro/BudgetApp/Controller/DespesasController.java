package com.laylamonteiro.BudgetApp.Controller;

import com.laylamonteiro.BudgetApp.Entity.Despesas;
import com.laylamonteiro.BudgetApp.Service.DespesasService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Data
@RestController
public class DespesasController {

    @Autowired
    final DespesasService despesasService;

    @GetMapping(path = "/despesas")
    @ResponseStatus(HttpStatus.OK)
    public List<Despesas> getAllDespesas() {
        return despesasService.findAll();
    }

    @GetMapping(path = "/despesa/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Despesas getDespesaById(@RequestParam("id") Long id) {
        return despesasService.findById(id);
    }

    @PostMapping(path = "/despesa")
    @ResponseStatus(HttpStatus.CREATED)
    public Despesas createDespesa(@Valid @RequestBody Despesas despesa) {
        return despesasService.create(despesa);
    }

    @PutMapping(path = "/despesa/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Despesas updateDespesa(@Valid @RequestBody Despesas despesa) {
        return despesasService.update(despesa);
    }

    @DeleteMapping(path = "/despesa/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDespesa(@RequestParam("id") Long id) {
        despesasService.delete(id);
    }
}
