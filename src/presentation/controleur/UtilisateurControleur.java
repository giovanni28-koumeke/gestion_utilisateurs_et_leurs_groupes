/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentation.controleur;

import entite.Groupe;
import entite.Utilisateur;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import presentation.vue.GroupeUI;
import presentation.vue.UtilisateurUI;
import service.UtilisateurService;

/**
 *
 * @author giova
 */
public class UtilisateurControleur {

    private final UtilisateurService service;

    GroupeControleur gc = new GroupeControleur();
    List<Groupe> listeGroupes = gc.TrouverGroupes();

    public UtilisateurControleur() {
        this.service = new UtilisateurService();
    }

    public void Ajouter() {
        Utilisateur utilisateur = new Utilisateur();

        UtilisateurUI utilisateurUI = new UtilisateurUI(utilisateur, listeGroupes);

        utilisateurUI.getBoutonEnregistrer().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (utilisateurUI.champValide()) {
                    utilisateurUI.modifierUtilisateur();
                    Utilisateur u = utilisateurUI.getUtilisateur();
                    service.Ajouter(u);
                    utilisateurUI.dispose();
                } else {
                    JOptionPane.showMessageDialog(
                            utilisateurUI,
                            "Entrez un nom de groupe",
                            "Nom inexistant",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });
        utilisateurUI.setVisible(true);
    }

    private Utilisateur TrouverAlerter(int id) {
        Utilisateur utilisateur = service.Trouver(id);
        if (utilisateur == null) {
            JOptionPane.showMessageDialog(null, "Aucun utilisateur trouvé avec cet ID");
        }
        return utilisateur;
    }

    public void Trouver(int id) {
        try {
            Utilisateur utilisateur = TrouverAlerter(id);
            UtilisateurUI utilisateurUI = new UtilisateurUI(utilisateur, listeGroupes);
            utilisateurUI.afficher();
            utilisateurUI.setVisible(true);
        } catch (Exception e) {
            System.out.println("Aucun utilisateur trouvé avec cet ID");
        }
    }

    public void Modifier() {
        try {
            List<Utilisateur> liste = service.trouverUtilisateurs();
            Utilisateur UtilisateurSelectionner = UtilisateurUI.selectionnerUtilisateur(null,
                    "Choix de l'utilisateur", liste);
            if(UtilisateurSelectionner == null){
                return;
            }
            UtilisateurUI utilisateurUI = new UtilisateurUI(UtilisateurSelectionner, listeGroupes);
            utilisateurUI.getBoutonEnregistrer().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    utilisateurUI.modifierUtilisateur();
                    Utilisateur u = utilisateurUI.getUtilisateur();
                    service.Modifier(u);
                    utilisateurUI.dispose();
                }
            });
            utilisateurUI.afficher();
            utilisateurUI.setVisible(true);
        } catch (Exception e) {
            System.out.println("Il n'existe pas cet utilisateur");
        }

    }

    public void Supprimer() {
        try {
            List<Utilisateur> liste = service.trouverUtilisateurs();
            Utilisateur UtilisateurSelectionner = UtilisateurUI.selectionnerUtilisateur(null,
                    "Choix de l'utilisateur", liste);
            if(UtilisateurSelectionner == null){
                return;
            }
            service.Supprimer(UtilisateurSelectionner);
        } catch (Exception e) {
            System.out.println("Il n'existe pas cet utilisateur");
        }

    }
    
    public List<Utilisateur> trouverUtilisateurs(){
        return service.trouverUtilisateurs();
    }

}
