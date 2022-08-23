package Operations;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import database.DBConnection;
import gui.MyGridBagConstraints;

public class IscriviTeam extends JPanel{

    public IscriviTeam(final Dimension dim, final DBConnection con) {
        String[] fields = {"CodiceTeam", "CodiceCampionato"};
        this.setPreferredSize(dim);
        this.setLayout(new BorderLayout());
        JPanel northPanel = new JPanel(new GridBagLayout());
        JPanel southPanel = new JPanel(new GridBagLayout());
        JPanel centerPanel = new JPanel(new GridBagLayout());
        //defining the constraints for the panels
        northPanel.setPreferredSize(new Dimension(dim.width, dim.height/3));
        northPanel.setBackground(Color.WHITE);
        southPanel.setPreferredSize(new Dimension(dim.width, dim.height/3));
        southPanel.setBackground(Color.white);
        centerPanel.setBackground(Color.white);
        //title
        JLabel title = new JLabel("Iscrizione Team");
        title.setFont(new Font("Arial", Font.BOLD, dim.width / 15));
        title.setForeground(Color.BLACK);
        northPanel.add(title);
        //Main label wih text
        JLabel text = new JLabel("Perfavore seleziona i codici per iscrivere un TEAM ad un CAMPIONATO", JLabel.CENTER);
        text.setFont(new Font("Arial", Font.ITALIC, dim.width / 40));
        centerPanel.add(text, new MyGridBagConstraints(0,0,10,1));
        //labels of input
        //String[] labels = {"Name", "Surname", "Fiscal Code", "Birth Date"};
        JComponent[] components = new JComponent[fields.length];
        //creating the input fields
        int i=0;
        int k=0;
        JComponent textField;
        for(String string : fields){
            JLabel label = new JLabel(string, JLabel.CENTER);
            label.setFont(new Font("Arial", Font.PLAIN, dim.width / 40));
            centerPanel.add(label, new MyGridBagConstraints(i,1,1,1));
            if(i==1){
                textField = new JComboBox<String>(con.getChampID());
            } else {
                textField = new JComboBox<String>(con.getTeams());
            }
            components[i]=textField;
            textField.setMinimumSize(new Dimension(dim.width/6, dim.height/15));
            textField.setFont(new Font("Arial", Font.PLAIN, dim.width / 40));
            textField.setPreferredSize(new Dimension(dim.width/6, dim.height/15));
            centerPanel.add(textField, new MyGridBagConstraints(k, 2, new Insets(0,0,0,0), GridBagConstraints.CENTER));
            k++;
            i++;
        }
        //button
        JButton register = new JButton("Effettua iscrizione");
        register.setFont(new Font("Arial", Font.PLAIN, dim.width / 40));
        register.setPreferredSize(new Dimension(dim.width/3, dim.height/10));
        JLabel error = new JLabel("", JLabel.CENTER);
        error.setForeground(Color.BLACK);
        error.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, dim.width / 30));
        southPanel.add(error, new MyGridBagConstraints(0,0,10,1));
        southPanel.add(register, new MyGridBagConstraints(0, 1, new Insets(0,0,0,0), GridBagConstraints.CENTER));
        //button actionlistener
        register.addActionListener((e) -> {
            String TeamString = ((JComboBox<String>)components[0]).getSelectedItem().toString();
            String champString = ((JComboBox<String>)components[1]).getSelectedItem().toString();
            if(champString.length()>0 && champString.length()<=20 && TeamString.length()>0 && TeamString.length()<=20){
                if(con.iscriviTeam(TeamString, champString)){
                    error.setText("Registrazione completata!");
                } else {
                    error.setText("Registrazione fallita!");
                }
            } else {
                error.setText("Registrazione fallita!");
            }
        });
        //adding panels to the page
        this.add(northPanel, BorderLayout.NORTH);
        this.add(southPanel, BorderLayout.SOUTH);
        this.add(centerPanel, BorderLayout.CENTER);
    }  
}
