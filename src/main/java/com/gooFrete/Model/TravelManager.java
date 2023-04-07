package com.gooFrete.Model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
    
}
