package com.laylamonteiro.BudgetApp.Controller;

import com.laylamonteiro.BudgetApp.DTO.ReceitaDTO;
import com.laylamonteiro.BudgetApp.Entity.Receita;
import com.laylamonteiro.BudgetApp.Service.ReceitasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ReceitaController {

    @Autowired
    ReceitasService receitasService;

    @GetMapping("/receitas")
    @ResponseStatus(HttpStatus.OK)
    public List<Receita> getAllDespesas() {
        return receitasService.findAll();
    }

    @GetMapping("/receita/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Receita getDespesaById(@PathVariable(name = "id") Long id) {
        return receitasService.findById(id);
    }

    @GetMapping("/receita")
    @ResponseStatus(HttpStatus.OK)
    public List<Receita> getDespesaByDescricao(@RequestParam String descricao) {
        return receitasService.findByDescricao(descricao);
    }

    @PostMapping("/receita")
    @ResponseStatus(HttpStatus.CREATED)
    public Receita createDespesa(@RequestBody ReceitaDTO receita) {
        return receitasService.create(receita);
    }

    @PutMapping("/receita")
    @ResponseStatus(HttpStatus.OK)
    public Receita updateDespesa(@Valid @RequestBody Receita receita) {
        return receitasService.update(receita);
    }

    @DeleteMapping("/receita/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDespesa(@PathVariable(name = "id") Long id) {
        receitasService.delete(id);
    }
}
