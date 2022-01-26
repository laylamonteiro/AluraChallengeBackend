package com.laylamonteiro.BudgetApp.Enum;

public enum CategoriaDespesa {

    ALIMENTACAO("Alimentação"),
    SAÚDE("Saúde"),
    MORADIA("Moradia"),
    TRANSPORTE("Transporte"),
    EDUCACAO("Educação"),
    LAZER("Lazer"),
    IMPREVISTOS("Imprevistos"),
    OUTROS("Outros");

    private final String categoria;

    CategoriaDespesa(final String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return categoria;
    }
}
