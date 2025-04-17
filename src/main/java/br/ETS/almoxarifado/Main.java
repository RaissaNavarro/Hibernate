package br.ETS.almoxarifado;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        //TRANSIENT

        Categoria escritorio = new Categoria("ESCRITORIO");
        Material caneta = new Material(new MaterialDTO("Caneta", "Só canetas", 3, escritorio));


        EntityManagerFactory factory = Persistence.createEntityManagerFactory("almoxarifado");
        EntityManager entityManager = JPAUtil.getEntityManager();

        CategoriaDAO categoriaDAO = new CategoriaDAO(entityManager);
        MaterialDAO materialDAO = new MaterialDAO(entityManager);


        entityManager.getTransaction().begin(); //ele é como se fosse um git init

        //MANAGED
        materialDAO.cadastrar(caneta);
        categoriaDAO.cadastrar(escritorio);

        escritorio.setNome("MATERIAL DE ESCRITÓRIO");
        entityManager.flush(); // sincroniza o banco com a entidade, é como se fosse um pull pra eles ficarem igual
        entityManager.clear(); // ele é o oposto do flush, tranfere o estado da entidade para deatched, aq é onde vc quer fazer
        // as alterações mas nn quer subir pro git ainda
        





        // ENVIANDO PRO BANCO DE DADOS / COMMIT
        entityManager.getTransaction().commit(); //como se fosse git commit
        entityManager.close(); //como se fosse o push finalizando
        //DEATCHED


    }
}