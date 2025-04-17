package br.ETS.almoxarifado;

import javax.persistence.EntityManager;

public class CategoriaDAO {

    private EntityManager entityManager;

    public CategoriaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(Categoria categoria){
        entityManager.getTransaction().begin();
        this.entityManager.persist(categoria);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void atualizar(Categoria categoria) {
        entityManager.getTransaction().begin();
        this.entityManager.merge(categoria);
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    public Material


}
