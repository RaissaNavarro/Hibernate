package br.ETS.almoxarifado;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        Categoria escritorio = new Categoria("ESCRITORIO");
        Material caneta = new Material(new MaterialDTO("Caneta", "Só canetas", 3, escritorio));
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("almoxarifado");
        EntityManager entityManager = JPAUtil.getEntityManager();
        CategoriaDAO categoriaDAO = new CategoriaDAO(entityManager);
        MaterialDAO materialDAO = new MaterialDAO(entityManager);


        entityManager.getTransaction().begin(); //ele é como se fosse um git init
        materialDAO.cadastrar(caneta);
        categoriaDAO.cadastrar(escritorio);
        entityManager.getTransaction().commit(); //como se fosse git commit
        entityManager.close(); //como se fosse o push finalizando


    }
}