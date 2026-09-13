/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jpa;

import entite.Groupe;
import entite.Utilisateur;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import javax.swing.UnsupportedLookAndFeelException;
import presentation.controleur.AcceilControleur;
import presentation.vue.AcceuilUI;

/**
 *
 * @author giova
 */
public class Jpa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        AcceilControleur acc = new AcceilControleur();
        
    }
    
    private static void test1(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaPU");
        EntityManager em = emf.createEntityManager();
        
        Groupe gl = new Groupe("Groupe 1", "Premier groupe");
        
        EntityTransaction transaction = em.getTransaction();
        try{
            transaction.begin();
            em.persist(gl);
            transaction.commit();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            transaction.rollback();
        }
    }
    
    private static void test2() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaPU");
        EntityManager em = emf.createEntityManager();

        Groupe g1 = new Groupe("Groupe 2", " Deuxième Groupe");
        Utilisateur utilisateur = new Utilisateur("KOUMEKE", "Giovanni", "jojo", "123456789");

        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(g1);
            transaction.commit();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
    }
    
}
