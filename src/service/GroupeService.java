/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.GroupeDao;
import entite.Groupe;
import java.util.List;

/**
 *
 * @author giova
 */
public class GroupeService {
    private final GroupeDao dao;
    
    public GroupeService(){
        this.dao = new GroupeDao();
    }
    
    public void Ajouter(Groupe groupe){
        this.dao.Ajouter(groupe);
    }
    
    public Groupe Trouver(int id){
        return dao.Trouver(id);
    }
    
//    public Groupe Trouver(String nom_du_groupe){
//        return null;
//    }
    
    public void Modifier(Groupe groupe){
        dao.Modifier(groupe);
    }
    
    public List<Groupe> lister(){
        return null;
    }
    
    public void Supprimer(Groupe groupe){
        dao.Supprimer(groupe);
    }
    
    public void Spprimer(String nom_du_groupe){
        
    }
    
    public List<Groupe> TrouverGroupes(){
        return dao.TrouverGroupes();
    }
}
