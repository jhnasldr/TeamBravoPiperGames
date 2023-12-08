package org.teambravo.controller;

import org.teambravo.entity.Staff;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class StaffClassController {

    public static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("hibernate");

    // CRUD

    //CREATE
    /* // Ska man kunna lägga till staff? Tänker att de kopplas direkt med foreign_keys
    public boolean saveStaff(Object staffClass) {
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
    */

    //READ - Läsa av staff id och person id
    public List<Staff> getAllStaff (boolean printOut){
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            List<Staff> staffResultList = entityManager.createQuery("FROM Staff ", Staff.class).getResultList();
            // teamClassToReturn.addAll(teamResultList.getResultList());
            transaction.commit();
            if (printOut) {
                for (Staff staffClass :
                        staffResultList) {
                    System.out.println(staffClass.getStaff_id() + ". " + staffClass.getPerson());

                }
            }
            return  staffResultList;

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

    /* // Behövs inte uppdatera staff tror jag

    public boolean updateTeam(org.teambravo.entity.Team teamClass){
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
    } */

    //Deletea staff utifrån
    public boolean deleteStaff(int staff_id) {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();


            Staff staffToDelete = entityManager.find(Staff.class, staff_id);

            if (staffToDelete != null) {
                entityManager.remove(staffToDelete);
                transaction.commit();
                return true;
            }

            transaction.rollback();
            return false;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            entityManager.close();
        }
    }


}




