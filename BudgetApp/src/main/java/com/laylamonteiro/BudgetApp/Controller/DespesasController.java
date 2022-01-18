package com.laylamonteiro.BudgetApp.Controller;

import com.laylamonteiro.BudgetApp.Service.DespesasService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@RestController
public class DespesasController {

    @Autowired
    final DespesasService despesasService;

    @RequestMapping("/despesas")
    public List<DespesasResponseDTO> getAllDespesas(){
        return despesasService.findAll();
    }
}
