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
import database.DBConnection.ComponentType;

import database.DBConnection;
import gui.MyGridBagConstraints;

public class AssegnaComponente extends JPanel{

    public AssegnaComponente(final Dimension dim, final DBConnection con) {
        String[] fields = {"Tipo Componente", "Codice Componente", "Codice Team", "Anno"};
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
        JLabel title = new JLabel("Assegna Componente");
        title.setFont(new Font("Arial", Font.BOLD, dim.width / 15));
        title.setForeground(Color.BLACK);
        northPanel.add(title);
        //Main label wih text
        JLabel text = new JLabel("Perfavore riempi i campi sottostanti per assegnare un COMPONENTE ad un TEAM", JLabel.CENTER);
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
            if(i==0){
                textField = new JComboBox<ComponentType>(ComponentType.values());
                ((JComboBox)textField).removeItem(ComponentType.SPETTATORI);
            } else {
                if(i==1){
                    textField = new JComboBox<String>(con.getComponentID(ComponentType.PILOTI));
                } else {
                    if(i==2){
                        textField = new JComboBox<String>(con.getTeams());
                    } else {
                        textField = new JTextField();
                    }
                }
            }
            components[i]=textField;
            textField.setMinimumSize(new Dimension(dim.width/6, dim.height/15));
            textField.setFont(new Font("Arial", Font.PLAIN, dim.width / 40));
            textField.setPreferredSize(new Dimension(dim.width/6, dim.height/15));
            centerPanel.add(textField, new MyGridBagConstraints(k, 2, new Insets(0,0,0,0), GridBagConstraints.CENTER));
            k++;
            i++;
        }

        ((JComboBox)components[0]).addActionListener((e) -> {
            ((JComboBox)components[1]).removeAllItems();
            for(String string : con.getComponentID((ComponentType)((JComboBox) components[0]).getSelectedItem())){
                ((JComboBox)components[1]).addItem(string);
            }
        });

        //button
        JButton register = new JButton("Effettua Registrazione");
        register.setFont(new Font("Arial", Font.PLAIN, dim.width / 40));
        register.setPreferredSize(new Dimension(dim.width/3, dim.height/10));
        JLabel error = new JLabel("", JLabel.CENTER);
        error.setForeground(Color.BLACK);
        error.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, dim.width / 30));
        southPanel.add(error, new MyGridBagConstraints(0,0,10,1));
        southPanel.add(register, new MyGridBagConstraints(0, 1, new Insets(0,0,0,0), GridBagConstraints.CENTER));
        //button actionlistener
        register.addActionListener((e) -> {
            String typeString = ((JComboBox<String>)components[0]).getSelectedItem().toString();
            String IDString = ((JComboBox<String>)components[1]).getSelectedItem().toString();
            String TeamString = ((JComboBox<String>)components[2]).getSelectedItem().toString();
            String AnnoString = ((JTextField)components[3]).getText();
            if(typeString.length()>0 && IDString.length()>0 && TeamString.length()>0 && AnnoString.length()==4){
                if(con.assegnaComponente(typeString, IDString, TeamString, AnnoString)){
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
