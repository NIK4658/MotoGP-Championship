package Operations;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import database.DBConnection;
import gui.MyGridBagConstraints;

public class ClassificaGare extends JPanel{

    public ClassificaGare(final Dimension dim, final DBConnection con) {
        String[] fields = {"Campionato", "Autodromo", "Anno"};
        this.setPreferredSize(dim);
        this.setLayout(new BorderLayout());
        JPanel westPanel = new JPanel(new GridBagLayout());
        CardLayout card = new CardLayout();
        JPanel eastPanel = new JPanel(card);
        //defining the constraints for the panels
        westPanel.setPreferredSize(new Dimension(dim.width/2, dim.height));
        westPanel.setBackground(Color.white);
        eastPanel.setPreferredSize(new Dimension(dim.width/2, dim.height));
        eastPanel.setBackground(Color.white);
        //title
        JLabel title = new JLabel("Classifiche", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, dim.width / 15));
        title.setForeground(Color.BLACK);
        westPanel.add(title, new MyGridBagConstraints(0,0,10,1));
        //Main label wih text
        JLabel text = new JLabel("Inserisci i dati e visualizza la classifica", JLabel.CENTER);
        text.setFont(new Font("Arial", Font.ITALIC, dim.width / 40));
        westPanel.add(text, new MyGridBagConstraints(0,1,10,1));
        //labels of input
        //String[] labels = {"Name", "Surname", "Fiscal Code", "Birth Date"};
        //creating the input fields
        JComponent[] components = new JComponent[fields.length];
        int i=0;
        int k=0;
        JComponent textField;
        for(String string : fields){
            JLabel label = new JLabel(string, JLabel.CENTER);
            label.setFont(new Font("Arial", Font.PLAIN, dim.width / 40));
            westPanel.add(label, new MyGridBagConstraints(i,2,1,1));
            if(i==0 ){
                textField = new JComboBox<String>(con.getChampID());
            } else {
                if(i==1){
                    textField = new JComboBox<String>(con.getAutodromoID());
                } else {
                    textField = new JTextField();
                }
            }
            components[i]=textField;
            textField.setMinimumSize(new Dimension(dim.width/6, dim.height/15));
            textField.setFont(new Font("Arial", Font.PLAIN, dim.width / 40));
            textField.setPreferredSize(new Dimension(dim.width/6, dim.height/15));
            westPanel.add(textField, new MyGridBagConstraints(k, 3, new Insets(0,10,0,10), GridBagConstraints.CENTER));
            k++;
            i++;
        }
        //button
        JButton register = new JButton("Visualizza");
        register.setFont(new Font("Arial", Font.PLAIN, dim.width / 40));
        register.setPreferredSize(new Dimension(dim.width/3, dim.height/10));
        westPanel.add(register, new MyGridBagConstraints(1, 4, new Insets(0,0,0,0), GridBagConstraints.CENTER));
        //button actionlistener
        JTabbedPane table2 = new JTabbedPane();
        eastPanel.add(table2, "table");
        register.addActionListener((e) -> {
            String champ = (String) ((JComboBox) components[0]).getSelectedItem();
            String autodromo = (String) ((JComboBox) components[1]).getSelectedItem();
            String anno = ((JTextField) components[2]).getText();
            if(champ.length()>0 && autodromo.length()>0 && anno.length()>0){
                JTabbedPane table = con.getClassifica(dim, champ, autodromo, anno);
                eastPanel.add(table, "table");
                card.show(eastPanel, "table");
            }
        });
        //adding panels to the page
        this.add(westPanel, BorderLayout.WEST);
        this.add(eastPanel, BorderLayout.EAST);
    }  
}
