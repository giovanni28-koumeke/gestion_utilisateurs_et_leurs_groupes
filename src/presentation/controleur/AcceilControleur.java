/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentation.controleur;

import entite.Groupe;
import entite.Utilisateur;
import java.util.List;
import presentation.vue.AcceuilUI;
import presentation.vue.GroupeUI;
import presentation.vue.UtilisateurUI;

/**
 *
 * @author giova
 */
public class AcceilControleur {
    
    public AcceilControleur(){
        AcceuilUI acceuilUI = new AcceuilUI();
        
        UtilisateurControleur utilisateurControleur = new UtilisateurControleur();
        GroupeControleur groupeControleur = new GroupeControleur();
        
        acceuilUI.getAjouterGroupe().addActionListener((e) -> {
            groupeControleur.Ajouter();
        });
        
        acceuilUI.getAjouterUtilisateur().addActionListener((e) -> {
            utilisateurControleur.Ajouter();
        });
        
        acceuilUI.getListerGroupes().addActionListener((e) -> {
            List<Groupe> listeGroupes = groupeControleur.TrouverGroupes();
            GroupeUI.afficherTableauGroupe(listeGroupes);
        });
        
        acceuilUI.getListerUtilisateurs().addActionListener((e) -> {
            List<Utilisateur> listeUtilisateur = utilisateurControleur.trouverUtilisateurs();
            UtilisateurUI.afficherTableauUtilisateur(listeUtilisateur);
        });
        
        acceuilUI.getModifierGroupe().addActionListener((e) -> {
            groupeControleur.Modifier();
        });
        
        acceuilUI.getModifierUtilisateur().addActionListener((e) -> {
            utilisateurControleur.Modifier();
        });
        
        acceuilUI.getSuppimerGroupe().addActionListener((e) -> {
            groupeControleur.Supprimer();
        });
        
        acceuilUI.getSuppimerUtilisateur().addActionListener((e) -> {
            utilisateurControleur.Supprimer();
        });
    }
}
