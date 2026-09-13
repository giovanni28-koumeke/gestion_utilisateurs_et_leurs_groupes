/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entite;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;

/**
 *
 * @author giova
 */
@Entity
@Table(name = "groupe")
public class Groupe implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "nom", nullable = false)
    private String nom_du_groupe;
    
    @Column(name ="description")
    private String description;
   
    
    public Groupe(){
        
    }
    
    public Groupe(String nom_du_groupe, String description){
        this.nom_du_groupe = nom_du_groupe;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom_du_groupe() {
        return nom_du_groupe;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
    
    public void setNom_du_groupe(String nom_du_groupe) {
        this.nom_du_groupe = nom_du_groupe;
    }

    @Override
    public String toString() {
        return nom_du_groupe;
    }
    
    
}
