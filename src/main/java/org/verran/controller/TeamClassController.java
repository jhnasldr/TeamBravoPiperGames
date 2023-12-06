package org.verran.controller;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class TeamClassController {

    public static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("hibernate");

    // CRUD

    //CREATE

    public boolean saveTeam(Object teamClass) {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(teamClass);
            transaction.commit();
            return true;
        } catch (Exception e){
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return false;

    }

    //READ
    public List<org.verran.entity.TeamClass> getAll (boolean printOut){
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        List<org.verran.entity.TeamClass> teamClassToReturn = new ArrayList<>();
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            TypedQuery<org.verran.entity.TeamClass> resultList = entityManager.createQuery("FROM TeamClass", org.verran.entity.TeamClass.class);
            teamClassToReturn.addAll(resultList.getResultList());
            transaction.commit();
            if (printOut) {
                for (org.verran.entity.TeamClass teamClass :
                        teamClassToReturn) {
                    System.out.println(teamClass.getTeamId() + ". " + teamClass.getTeamName());

                }
            }
            return  teamClassToReturn;

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return null;
    }
    public boolean updateTeam(org.verran.entity.TeamClass teamClass){
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.merge(teamClass);
            transaction.commit();
            return true;
        } catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return false;
    }
    public boolean deleteTeam(org.verran.entity.TeamClass teamClass){
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            // If the entity is attached then remove customer, else merge(attach/update) entity and then remove
            entityManager.remove(entityManager.contains(teamClass) ? teamClass:entityManager.merge(teamClass));
            transaction.commit();
            return true;
        } catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return false;
    }



}
