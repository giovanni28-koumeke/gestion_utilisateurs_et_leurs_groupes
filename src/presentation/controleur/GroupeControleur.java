/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentation.controleur;

import entite.Groupe;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import presentation.vue.GroupeUI;
import service.GroupeService;

/**
 *
 * @author giova
 */
public class GroupeControleur {

    private final GroupeService service;

    public GroupeControleur() {
        this.service = new GroupeService();
    }

    public void Ajouter() {
        Groupe groupe = new Groupe();
        GroupeUI groupeUI = new GroupeUI(groupe);

        groupeUI.getBoutonEnregistrer().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (groupeUI.champValide()) {
                    groupeUI.ModifierGroupe();
                    Groupe g = groupeUI.getGroupe();
                    service.Ajouter(g);
                    groupeUI.dispose();
                } else {
                    JOptionPane.showMessageDialog(
                            groupeUI,
                            "Entrez un nom de groupe",
                            "Nom inexistant",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });
        groupeUI.setVisible(true);
    }

    private Groupe TrouverAlerter(int id) {
        Groupe groupe = service.Trouver(id);
        if (groupe == null) {
            JOptionPane.showMessageDialog(null, "Aucun groupe trouvé avec cet ID");
        }
        return groupe;
    }

    public void Trouver(int id) {
        try {
            Groupe groupe = TrouverAlerter(id);
            GroupeUI groupeUI = new GroupeUI(groupe);
            groupeUI.afficher();
            groupeUI.setVisible(true);
        } catch (Exception e) {
            System.out.println("Aucun groupe trouvé avec cet ID");
        }
    }

    public void Modifier() {
        try {
            List<Groupe> liste = service.TrouverGroupes();
            Groupe groupeSelectionner = GroupeUI.selectionerGroupe(null,
                    "Choix du groupe", liste);
            if(groupeSelectionner == null){
                return;
            }
            GroupeUI groupeUI = new GroupeUI(groupeSelectionner);
            groupeUI.getBoutonEnregistrer().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    groupeUI.ModifierGroupe();
                    Groupe g = groupeUI.getGroupe();
                    service.Modifier(g);
                    groupeUI.dispose();
                }
            });

            groupeUI.afficher();
            groupeUI.setVisible(true);
        } catch (Exception e) {
            System.out.println("Aucun groupe trouvé avec cet ID");
        }

    }

    public void Supprimer() {
        try {
            List<Groupe> liste = service.TrouverGroupes();
            Groupe groupeSelectionner = GroupeUI.selectionerGroupe(null,
                    "Choix du groupe", liste);
            if(groupeSelectionner == null){
                return;
            }
            service.Supprimer(groupeSelectionner);
        } catch (Exception e) {
            System.out.println("Il n'existe pas de groupe avec cet ID");
        }

    }

    public List<Groupe> TrouverGroupes() {
        return service.TrouverGroupes();
    }
}
