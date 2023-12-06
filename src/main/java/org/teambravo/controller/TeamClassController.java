package org.teambravo.controller;

import org.teambravo.entity.TeamClass;

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
    public List<TeamClass> getAllTeams (boolean printOut){
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            List<TeamClass> teamResultList = entityManager.createQuery("FROM TeamClass", TeamClass.class).getResultList();
            // teamClassToReturn.addAll(teamResultList.getResultList());
            transaction.commit();
            if (printOut) {
                for (TeamClass teamClass :
                        teamResultList) {
                    System.out.println(teamClass.getTeamId() + ". " + teamClass.getTeamName());

                }
            }
            return  teamResultList;

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
    public boolean updateTeam(org.teambravo.entity.TeamClass teamClass){
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
    public boolean deleteTeam(org.teambravo.entity.TeamClass teamClass){
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
