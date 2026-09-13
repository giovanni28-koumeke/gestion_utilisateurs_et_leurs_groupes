/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentation.vue;

import entite.Groupe;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author giova
 */
public class GroupeUI extends JFrame{
    private final Groupe groupe;
    private JTextField nom;
    private JTextField description;
    private JButton boutonEnregistrer;
    
    public GroupeUI(Groupe groupe){
        this.groupe = groupe;
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setSize(400,300);
        this.setLocationRelativeTo(null);
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        layout.setConstraints(this, c);
        this.setLayout(layout);
        this.setTitle("Ajout de groupe");
        
        nom = new JTextField(20);
        description = new JTextField(20);
        boutonEnregistrer = new JButton("Enregistrer");
        

        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(5, 5, 5, 5);
        this.add(new JLabel("nom"), c);
        c.gridx = 1;
        this.add(nom, c);
        
        c.gridx = 0;
        c.gridy = 1;
        this.add(new JLabel("Description"), c);
        c.gridx = 1;
        this.add(description, c);
        
        c.gridx = 1;
        c.gridy = 2;
        this.add(boutonEnregistrer, c);
        
        
    }
    
    public void afficher(){
        this.nom.setText(this.groupe.getNom_du_groupe());
        this.description.setText(this.groupe.getDescription());
    }
    
    public void ModifierGroupe(){
        this.groupe.setNom_du_groupe(nom.getText());
        this.groupe.setDescription(description.getText());
    }
    
    public static Groupe selectionerGroupe(Component parent,
            String titre, java.util.List<Groupe> listeGroupes){
        if (listeGroupes == null || listeGroupes.isEmpty()){
            JOptionPane.showMessageDialog(parent, "Aucun groupes trouver", "Information",
                    JOptionPane.INFORMATION_MESSAGE);
            return null;
        }
         
        JComboBox<Groupe> combo = new JComboBox<>(listeGroupes.toArray(new Groupe[0]));
        int option = JOptionPane.showConfirmDialog(parent, combo, titre,
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (option == JOptionPane.OK_OPTION){
            return (Groupe) combo.getSelectedItem();
        }
        return null;
    }
    
    public static void afficherTableauGroupe(List<Groupe> listeGroupes){
        if (listeGroupes == null || listeGroupes.isEmpty()){
            JOptionPane.showMessageDialog(null, "Aucun groupes trouver", "Information",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        String[] colonnes = {"Nom du groupe", "Description"};
        DefaultTableModel model = new DefaultTableModel(colonnes, 0);
        
        for(Groupe g : listeGroupes){
            Object[] ligne = {g.getNom_du_groupe(), g.getDescription()};
            model.addRow(ligne);
        }
        
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        
        JOptionPane.showMessageDialog(null, scrollPane,
                "Liste de tous les groupes", JOptionPane.PLAIN_MESSAGE);
   }
    
    public Groupe getGroupe(){
        return groupe;
    }
    
    public JButton getBoutonEnregistrer(){
        return boutonEnregistrer;
    }
    
    public boolean champValide(){
        return !nom.getText().trim().isEmpty();
    }
}
