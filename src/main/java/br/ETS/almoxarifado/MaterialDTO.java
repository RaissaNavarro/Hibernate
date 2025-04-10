package br.ETS.almoxarifado;

public record MaterialDTO(String nome,
                          String fornecedor,
                          int quantidade,
                          Categoria categoria) {

}
