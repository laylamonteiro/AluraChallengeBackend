package com.laylamonteiro.BudgetApp.Controller;

import com.laylamonteiro.BudgetApp.Entity.Receitas;
import com.laylamonteiro.BudgetApp.Service.ReceitasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ReceitasController {

    @Autowired
    ReceitasService receitasService;

    @GetMapping("/receitas")
    @ResponseStatus(HttpStatus.OK)
    public List<Receitas> getAllDespesas() {
        return receitasService.findAll();
    }

    @GetMapping("/receitas/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Receitas getDespesaById(@PathVariable(name = "id") Long id) {
        return receitasService.findById(id);
    }

    @PostMapping("/receitas")
    @ResponseStatus(HttpStatus.CREATED)
    public Receitas createDespesa(@RequestBody Receitas receitas) {
        return receitasService.create(receitas);
    }

    @PutMapping("/receitas")
    @ResponseStatus(HttpStatus.OK)
    public Receitas updateDespesa(@Valid @RequestBody Receitas receitas) {
        return receitasService.update(receitas);
    }

    @DeleteMapping("/receitas/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDespesa(@PathVariable(name = "id") Long id) {
        receitasService.delete(id);
    }
}
