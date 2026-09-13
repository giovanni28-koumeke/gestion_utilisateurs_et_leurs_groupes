/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entite.Groupe;
import entite.Utilisateur;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.util.List;

/**
 *
 * @author giova
 */
public class UtilisateurDao {

    private final EntityManagerFactory emf;

    public UtilisateurDao() {
        this.emf = Persistence.createEntityManagerFactory("jpaPU");
    }

    public void Ajouter(Utilisateur utilisateur) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(utilisateur);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw ex;
        } finally {
            em.close();
        }
    }

    public Utilisateur Trouver(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Utilisateur.class, id);
        } finally {
            em.close();
        }
    }

    public void Modifier(Utilisateur utilisateur) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.merge(utilisateur);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw ex;
        } finally {
            em.close();
        }
    }

    public void Supprimer(Utilisateur utilisateur) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Utilisateur managed = em.merge(utilisateur);
            em.remove(managed);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw ex;
        } finally {
            em.close();
        }
    }
    
    public List<Utilisateur> trouverUtilisateur(){
        EntityManager em = emf.createEntityManager();
        try {
            return em.createNativeQuery("SELECT * FROM utilisateurs", Utilisateur.class).getResultList();
        } finally {
            em.close();
        }
    }
}
