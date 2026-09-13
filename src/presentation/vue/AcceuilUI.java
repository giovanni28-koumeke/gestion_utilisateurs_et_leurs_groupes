/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentation.vue;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author giova
 */
public class AcceuilUI extends JFrame{

    private JButton ajouterUtilisateur;
    private JButton listerUtilisateurs;
    private JButton modifierUtilisateur;
    private JButton suppimerUtilisateur;

    private JButton ajouterGroupe;
    private JButton listerGroupes;
    private JButton modifierGroupe;
    private JButton suppimerGroupe;


    public AcceuilUI() {
        this.setTitle("Acceuil");
        this.setSize(500, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        layout.setConstraints(this, c);
        this.setLayout(layout);
        
        
        Dimension d = new Dimension(200,40);

        listerGroupes = new JButton("Lister tous les groupes");
        listerGroupes.setPreferredSize(d);
        
        listerUtilisateurs = new JButton("Lister tous les utilisateurs");
        listerUtilisateurs.setPreferredSize(d);
        
        ajouterGroupe = new JButton("Ajouter un groupe");
        ajouterGroupe.setPreferredSize(d);
        
        ajouterUtilisateur = new JButton("Ajouter un utilisateur");
        ajouterUtilisateur.setPreferredSize(d);
        
        modifierGroupe = new JButton("Modifier un groupe");
        modifierGroupe.setPreferredSize(d);
        
        modifierUtilisateur = new JButton("Modifier un utilisateur");
        modifierUtilisateur.setPreferredSize(d);
        
        suppimerGroupe = new JButton("Supprimer un groupe");
        suppimerGroupe.setPreferredSize(d);
        
        suppimerUtilisateur = new JButton("Supprimer un utilisateur");
        suppimerUtilisateur.setPreferredSize(d);
        
//        infos = new JLabel("!!! IL N'EST PAS POSSIBLE DE SUPPRIMER UN GROUPE AUQUEL APPARTIENT DES UTILISATEURS (Violation de la contrainte de clé étrangère) ");
////        infos.setLineWrap(true);
////        infos.setEditable(false);
////        infos.setForeground(Color.red);
//        infos.setPreferredSize(new Dimension(50, 30));
//        JScrollPane scroll = new JScrollPane(infos);
        
        
        c.insets = new Insets(5, 5, 5, 5);
        
        c.gridx = 0;
        c.gridy = 0;
        this.add(ajouterGroupe, c);
        
        c.gridx = 1;
        c.gridy = 0;
        this.add(ajouterUtilisateur, c);
        
        c.gridx = 0;
        c.gridy = 1;
        this.add(listerGroupes, c);
        
        c.gridx = 1;
        c.gridy = 1;
        this.add(listerUtilisateurs,c);
        
        c.gridx = 0;
        c.gridy = 2;
        this.add(modifierGroupe, c);
        
        c.gridx = 1;
        c.gridy = 2;
        this.add(modifierUtilisateur, c);
        
        c.gridx = 0;
        c.gridy = 3;
        this.add(suppimerGroupe, c);
        
        c.gridx = 1;
        c.gridy = 3;
        this.add(suppimerUtilisateur, c);
        
//        this.add(cta, BorderLayout.CENTER);
//        this.add(scroll, BorderLayout.SOUTH);
        
        setVisible(true);
    }

    public JButton getListerUtilisateurs() {
        return listerUtilisateurs;
    }

    public JButton getAjouterUtilisateur() {
        return ajouterUtilisateur;
    }

    public JButton getModifierUtilisateur() {
        return modifierUtilisateur;
    }

    public JButton getSuppimerUtilisateur() {
        return suppimerUtilisateur;
    }

    public JButton getAjouterGroupe() {
        return ajouterGroupe;
    }

    public JButton getListerGroupes() {
        return listerGroupes;
    }

    public JButton getModifierGroupe() {
        return modifierGroupe;
    }

    public JButton getSuppimerGroupe() {
        return suppimerGroupe;
    }

}
