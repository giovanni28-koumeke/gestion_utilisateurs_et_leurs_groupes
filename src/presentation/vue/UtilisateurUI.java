/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentation.vue;

import entite.Groupe;
import entite.Utilisateur;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author giova
 */
public class UtilisateurUI extends JFrame{
   private final Utilisateur utilisateur;
   private JTextField nom;
   private JTextField prenom;
   private JTextField identifiant;
   private JPasswordField mot_de_passe;
   private JComboBox<Groupe> groupe;
   private JButton boutonEnregistrer;

   public UtilisateurUI(Utilisateur utilisateur, List<Groupe> listeGroupes){
       this.utilisateur = utilisateur;
       this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
       this.setSize(400, 300);
       this.setLocationRelativeTo(null);
       GridBagLayout layout = new GridBagLayout();
       GridBagConstraints c = new GridBagConstraints();
       layout.setConstraints(this, c);
       this.setLayout(layout);
       this.setTitle("Ajout d'utilisateur");
       
       nom = new JTextField(20);
       prenom = new JTextField(20);
       identifiant = new JTextField(20);
       mot_de_passe = new JPasswordField(20);
       groupe = new JComboBox<>(new DefaultComboBoxModel(listeGroupes.toArray(new Groupe[0])));
       boutonEnregistrer = new JButton("Enregistrer");
       
       c.insets = new Insets(5, 5, 5, 5);
       
       c.gridx = 0;
       c.gridy = 0;
       this.add(new JLabel("Nom"), c);
       c.gridx = 1;
       this.add(nom, c);
       
       c.gridx = 0;
       c.gridy = 1;
       this.add(new JLabel("Prenom"), c);
       c.gridx = 1;
       this.add(prenom, c);
       
       c.gridx = 0;
       c.gridy = 2;
       this.add(new JLabel("Identifiant"), c);
       c.gridx = 1;
       this.add(identifiant, c);
       
       c.gridx = 0;
       c.gridy = 3;
       this.add(new JLabel("Mot de passe"), c);
       c.gridx = 1;
       this.add(mot_de_passe, c);
       
       c.gridx = 0;
       c.gridy = 4;
       this.add(new JLabel("Groupe"), c);
       c.gridx = 1;
       this.add(groupe, c);
       
       c.gridx = 1;
       c.gridy = 5;
       this.add(boutonEnregistrer, c);
       
   }
   
   public void afficher(){
       this.nom.setText(this.utilisateur.getNom());
       this.prenom.setText(this.utilisateur.getPrenom());
       this.identifiant.setText(this.utilisateur.getIdentifiant());
       this.mot_de_passe.setText(this.utilisateur.getMot_de_passe());
       if (this.utilisateur.getGroupe() != null){
           this.groupe.setSelectedItem(this.utilisateur.getGroupe());
       }
   }
   
   public void modifierUtilisateur(){
       this.utilisateur.setNom(nom.getText());
       this.utilisateur.setPrenom(prenom.getText());
       this.utilisateur.setIdentifiant(identifiant.getText());
       this.utilisateur.setMot_de_passe(new String(mot_de_passe.getPassword()));
       this.utilisateur.setGroupe((Groupe) groupe.getSelectedItem());
   }
   
   public static Utilisateur selectionnerUtilisateur(Component parent, String titre,
          java.util.List<Utilisateur> listeUtilisateurs){
       if(listeUtilisateurs == null || listeUtilisateurs.isEmpty()){
            JOptionPane.showMessageDialog(parent, "Aucun utilisateur trouver", "Information",
                    JOptionPane.INFORMATION_MESSAGE);
            return null;
       }
       
       JComboBox<Utilisateur> combo = new JComboBox<>(listeUtilisateurs.toArray(new Utilisateur[0]));
       int option = JOptionPane.showConfirmDialog(parent, combo, titre, JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
       if (option == JOptionPane.OK_OPTION){
            return (Utilisateur) combo.getSelectedItem();
       }
       return null;
   }
   
   public static void afficherTableauUtilisateur(List<Utilisateur> listeUtilisateur){
        if (listeUtilisateur == null || listeUtilisateur.isEmpty()){
            JOptionPane.showMessageDialog(null, "Aucun utilisateur trouver", "Information",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        String[] colonnes = {"Nom", "Prenom", "Identifiant", "Groupe"};
        DefaultTableModel model = new DefaultTableModel(colonnes, 0);
        
        for(Utilisateur u : listeUtilisateur){
            Object[] ligne = {u.getNom(), u.getPrenom(), u.getIdentifiant(), u.getGroupe()};
            model.addRow(ligne);
        }
        
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        
        JOptionPane.showMessageDialog(null, scrollPane,
                "Liste de tous les utilisateurs", JOptionPane.PLAIN_MESSAGE);
   }
   
   public Utilisateur getUtilisateur(){
       return utilisateur;
   }
   
   public JButton getBoutonEnregistrer(){
       return boutonEnregistrer;
   }
   
   public boolean champValide(){
       return !nom.getText().trim().isEmpty() &&
              !identifiant.getText().trim().isEmpty();
   }
}
