package com.gooFrete.Model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transaction;
import org.hibernate.Session;

public class TravelManager {
    
    private String connectionString;
    
    public TravelManager() {
        DatabaseConfig databaseConfig = new DatabaseConfig();
        this.connectionString = databaseConfig.getConnectionString();
    }
    
    public boolean travelInsert(Travel travel){
        try {
            // Inicializa o EntityManager do Hibernate
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPU");
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            // Inicia a transação
            entityManager.getTransaction().begin();

            // Persiste o objeto Produto no banco de dados
            //System.out.println("teste: " + travel.getId().toString());
            entityManager.persist(travel);

            // Confirma a transação
            entityManager.getTransaction().commit();

            // Fecha o EntityManager
            entityManager.close();
            entityManagerFactory.close();
            return true;
        } catch (Exception e) {
                System.out.println("Erro na persistência de dados da viagem.");
                return false;
        }
    }
    
    public boolean travelDelete(String identification) {
        try {
            // Inicializa o EntityManager do Hibernate
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPU");
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            // Inicia a transação
            entityManager.getTransaction().begin();

            // Busca a entidade Travel com o ID especificado
            Travel travel = entityManager.find(Travel.class, findTravelByIdentification(identification).getId());

            if (travel != null) {
                // Remove a viagem
                entityManager.remove(travel);

                // Confirma a transação
                entityManager.getTransaction().commit();

                // Fecha o EntityManager
                entityManager.close();
                entityManagerFactory.close();

                return true;
            } else {
                throw new Exception("Viagem não encontrada.");
            }
        } catch (Exception e) {
            System.out.println("Erro na exclusão de dados da viagem: " + e.getMessage());
            return false;
        }
    }
    
    public Travel findTravelByIdentification(String identification) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<Travel> query = entityManager.createQuery("SELECT t FROM Travel t WHERE t.identification = :identification", Travel.class);
        query.setParameter("identification", identification);
        List<Travel> results = query.getResultList();
        entityManager.close();
        entityManagerFactory.close();

        if (!results.isEmpty()) {
            return results.get(0);
        } else {
            return null;
        }
    }
    
    public String getIdentificationNumber() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("SELECT count(*) FROM Travel");
        List<Long> results = query.getResultList();
        entityManager.close();
        entityManagerFactory.close();
        
        //Soma 1
        long retorno = results.get(0) + 1;

        if (!results.isEmpty()) {
            return  String.valueOf(retorno);
        } else {
            return null;
        }
    }
    
    public List<Travel> travelQueryAll() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<Travel> query = entityManager.createQuery("FROM Travel order by InsertDate", Travel.class);
        List<Travel> results = query.getResultList();
        entityManager.close();
        entityManagerFactory.close();

        if (!results.isEmpty()) {
            return results;
        } else {
            return null;
        }
    }
    
}
