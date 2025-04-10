package br.ETS.almoxarifado;

import javax.persistence.EntityManager;
import javax.swing.text.html.parser.Entity;

public class CategoriaDAO {
    private EntityManager entityManager;

    public CategoriaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(Categoria categoria){
        this.entityManager.persist(categoria);
    }
}
