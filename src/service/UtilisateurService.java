/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.UtilisateurDao;
import entite.Utilisateur;
import java.util.List;

/**
 *
 * @author giova
 */
public class UtilisateurService {
    private final UtilisateurDao dao;
    
    public UtilisateurService(){
        this.dao = new UtilisateurDao();
    }
    
    public void Ajouter(Utilisateur utilisateur){
        this.dao.Ajouter(utilisateur);
    }
    
    public Utilisateur Trouver(int id){
        return dao.Trouver(id);
    }
    
    public Utilisateur Trouver(String identiant){
        return null;
    }
    
    public void Modifier(Utilisateur utilisateur){
        dao.Modifier(utilisateur);
    }
    
    public List<Utilisateur> lister(){
        return null;
    }
    
    public void Supprimer(Utilisateur utilisateur){
        dao.Supprimer(utilisateur);
    }
    
    public void Supprimer(int id){
        
    }
    
    public void supprimer(String identifiant){
        
    }
    
    public List<Utilisateur> trouverUtilisateurs(){
        return dao.trouverUtilisateur();
    }
}
