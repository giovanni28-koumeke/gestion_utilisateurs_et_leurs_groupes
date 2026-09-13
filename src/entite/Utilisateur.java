/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entite;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;

/**
 *
 * @author giova
 */
@Entity
@Table(name = "utilisateurs")
public class Utilisateur implements Serializable{
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "nom", length = 60, nullable = false)
    private String nom;
    
    @Column(name = "prenom", length = 60, nullable = true)
    private String prenom;
    
    @Column(name = "identifiant", length = 60, nullable = false)
    private String identifiant;
    
    @Column(name = "mot_de_passe", length = 60, nullable = true)
    private String mot_de_passe;
    
    @ManyToOne
    @JoinColumn(name = "id_groupe")
    private Groupe groupe;
    
    public Utilisateur(){
        
    }

    public Utilisateur(String nom, String prenom, String identifiant, String mot_de_passe, Groupe groupe) {
        this.nom = nom;
        this.prenom = prenom;
        this.identifiant = identifiant;
        this.mot_de_passe = mot_de_passe;
        this.groupe = groupe;
    }
    
    public Utilisateur(String nom, String prenom, String identifiant, String mot_de_passe){
        this.nom = nom;
        this.prenom = prenom;
        this.identifiant = identifiant;
        this.mot_de_passe = mot_de_passe;
    }

    public Integer getId() {
        return id;
    }
    
    
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getMot_de_passe() {
        return mot_de_passe;
    }

    public void setMot_de_passe(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }

    public Groupe getGroupe() {
        return groupe;
    }

    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }

    @Override
    public String toString() {
        return nom;
    }
    
    
}
