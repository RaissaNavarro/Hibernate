package br.ETS.almoxarifado;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table (name = "tbmateriaisindiretos")
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private LocalDate dataCadastro = LocalDate.now();

    @ManyToOne
    private Categoria categoria;

    private String nome;
    @Column(name = "Forn")
    private String fornecedor;
    private int quantidade;

    public Material(MaterialDTO materialDTO){
        this.nome = materialDTO.nome();
        this.fornecedor = materialDTO.fornecedor();
        this.quantidade = materialDTO.quantidade();
        this.categoria = materialDTO.categoria();
    }

    public int getId(){
        return id;
    }


}
