package com.laylamonteiro.BudgetApp.Controller;

import com.laylamonteiro.BudgetApp.DTO.DespesaDTO;
import com.laylamonteiro.BudgetApp.Entity.Despesa;
import com.laylamonteiro.BudgetApp.Service.DespesasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DespesaController {

    @Autowired
    DespesasService despesasService;

    @GetMapping("/despesas")
    @ResponseStatus(HttpStatus.OK)
    public List<Despesa> getAllDespesas() {
        return despesasService.findAll();
    }

    @GetMapping("/despesa/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Despesa getDespesaById(@PathVariable(name = "id") Long id) {
        return despesasService.findById(id);
    }

    @GetMapping("/despesa")
    @ResponseStatus(HttpStatus.OK)
    public List<Despesa> getDespesaByDescricao(@RequestParam String descricao) {
        return despesasService.findByDescricao(descricao);
    }

    @PostMapping("/despesa")
    @ResponseStatus(HttpStatus.CREATED)
    public Despesa createDespesa(@RequestBody DespesaDTO despesa) {
        return despesasService.create(despesa);
    }

    @PutMapping("/despesa")
    @ResponseStatus(HttpStatus.OK)
    public Despesa updateDespesa(@Valid @RequestBody Despesa despesa) {
        return despesasService.update(despesa);
    }

    @DeleteMapping("/despesa/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDespesa(@PathVariable(name = "id") Long id) {
        despesasService.delete(id);
    }
}
