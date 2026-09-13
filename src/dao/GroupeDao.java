/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entite.Groupe;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.util.List;

/**
 *
 * @author giova
 */
public class GroupeDao {
    private final EntityManagerFactory emf;
    //private EntityManager em;
    
    public GroupeDao(){
        this.emf = Persistence.createEntityManagerFactory("jpaPU");
    }
    
    public void Ajouter(Groupe groupe){
         EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try{
            transaction.begin();
            em.persist(groupe);
            transaction.commit();
        }catch(Exception ex){
            if(transaction.isActive()){
                transaction.rollback();
            }
            throw ex;
        }finally{
            em.close();
        }
    }
    
    public Groupe Trouver(int id){
        EntityManager em = emf.createEntityManager();
        try{
            return em.find(Groupe.class, id);
        }finally{
            em.close();
        }
    }
    
    public void Modifier(Groupe groupe){
        
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try{
            transaction.begin();
            em.merge(groupe);
            transaction.commit();
        }catch(Exception ex){
            if(transaction.isActive()){
                transaction.rollback();
            }
            throw ex;
        }finally{
            em.close();
        }
    }
    
    public void Supprimer(Groupe groupe){
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try{
            transaction.begin();
            Groupe managed = em.merge(groupe);
            em.remove(managed);
            transaction.commit();
        }catch(Exception ex){
            if(transaction.isActive()){
                transaction.rollback();
            }
            throw ex;
        }finally{
            em.close();
        }
    }
    
    public List<Groupe> TrouverGroupes(){
        EntityManager em = emf.createEntityManager();
        try {
            return em.createNativeQuery("SELECT * FROM groupe", Groupe.class).getResultList();
        } finally {
            em.close();
        }
    }
    
}
