package br.ETS.almoxarifado;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        Categoria escritorio = new Categoria("ESCRITÓRIO");
        //TRANSIENT
        EntityManager entityManager = JPAUtil.getEntityManager();
        MaterialDAO materialDAO = new MaterialDAO(entityManager);
        CategoriaDAO categoriaDAO = new CategoriaDAO(entityManager);

        Categoria escritorio = new Categoria("Informatica");
        Material material = new Material(new MaterialDTO("Monitor", "Só Canetas", 5, escritorio));

        entityManager.getTransaction().begin();


        MaterialDAO.lerDadosTabela().forEach(m -> System.out.println(m.getNome()));

        entityManager.getTransaction().commit();
        entityManager.close();

//        entityManager.getTransaction().begin();
//        categoriaDAO.cadastrar(escritorio);
//        //MANAGED //ele so vira managed depoois o persist que estar em cadastrar
//
//        escritorio.setNome("MATERIAL DE ESCRITÓRIO");
//        entityManager.flush();
//        entityManager.clear();
//        //DEATCHED
//        entityManager.merge(escritorio); // ele é o oposto do clear, do deatched pro managed
//        //MANAGED
//        escritorio.setNome("MATERIAL");
//        entityManager.flush();







    }
}