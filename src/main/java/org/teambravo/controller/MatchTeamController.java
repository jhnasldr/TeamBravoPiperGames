package org.teambravo.controller;

import org.teambravo.entity.MatchSoloPlayer;
import org.teambravo.entity.MatchTeam;
import org.teambravo.entity.Person;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
public class MatchTeamController {

    public static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("hibernate");

    // Create
    public void createMatchTeam(MatchTeam matchTeam) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;

        try {
            et = em.getTransaction();
            et.begin();
            em.persist(matchTeam);
            et.commit();
        } catch (Exception e) {
            if (et != null) {
                et.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    // Read
    public List<MatchTeam> getAllMatches() {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        String query = "SELECT t FROM MatchTeam t";
        List<MatchTeam> teamMatches = em.createQuery(query, MatchTeam.class).getResultList();
        em.close();
        return teamMatches;
    }

    public Optional<MatchTeam> getMatchById(int matchId) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        MatchTeam matchTeam = em.find(MatchTeam.class, matchId);
        em.close();
        return Optional.ofNullable(matchTeam);
    }

    // Update
    public void updateTeamMatch(MatchTeam matchTeam) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;

        try {
            et = em.getTransaction();
            et.begin();
            em.merge(matchTeam);
            et.commit();
        } catch (Exception e) {
            if (et != null) {
                et.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    // Delete
    public void deleteTeamMatch(int matchId) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;

        try {
            et = em.getTransaction();
            et.begin();
            MatchTeam matchTeam = em.find(MatchTeam.class, matchId);
            em.remove(matchTeam);
            et.commit();
        } catch (Exception e) {
            if (et != null) {
                et.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
