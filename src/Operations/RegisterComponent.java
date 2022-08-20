package Operations;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.mysql.cj.conf.ConnectionUrl.Type;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;
import java.awt.BorderLayout;
import database.DBConnection;
import gui.MyGridBagConstraints;
import database.DBConnection.ComponentType;

public class RegisterComponent extends JPanel{

    public RegisterComponent(final Dimension dim, final DBConnection con, final ComponentType type, final String[] fields) {
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
        JLabel title = new JLabel("Registrazione " + type);
        title.setFont(new Font("Arial", Font.BOLD, dim.width / 15));
        title.setForeground(Color.BLACK);
        northPanel.add(title);
        //Main label wih text
        JLabel text = new JLabel("Perfavore riempi i campi sottostanti per registrare dei nuovi "+type, JLabel.CENTER);
        text.setFont(new Font("Arial", Font.ITALIC, dim.width / 40));
        centerPanel.add(text, new MyGridBagConstraints(0,0,10,1));
        //labels of input
        //String[] labels = {"Name", "Surname", "Fiscal Code", "Birth Date"};
        JTextField[] components = new JTextField[fields.length];
        //creating the input fields
        int i=0;
        int k=0;
        for(String string : fields){
            JLabel label = new JLabel(string, JLabel.CENTER);
            label.setFont(new Font("Arial", Font.PLAIN, dim.width / 40));
            centerPanel.add(label, new MyGridBagConstraints(i,1,1,1));
            JTextField textField = new JTextField();
            components[i]=textField;
            textField.setMinimumSize(new Dimension(dim.width/6, dim.height/15));
            textField.setFont(new Font("Arial", Font.PLAIN, dim.width / 40));
            textField.setPreferredSize(new Dimension(dim.width/6, dim.height/15));
            centerPanel.add(textField, new MyGridBagConstraints(k, 2, new Insets(0,0,0,0), GridBagConstraints.CENTER));
            k++;
            i++;
        }
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
            String nameString = components[0].getText();
            String surnameString = components[1].getText();
            String fcString = components[2].getText();
            String birthString = components[3].getText();
            if(nameString.length()>0 && surnameString.length()>0 && fcString.length()>0 && birthString.length()>0 && fcString.length()==16 && nameString.length()<=20 && surnameString.length()<=20 && con.validDate(birthString)){
                con.registerComponent(nameString, surnameString, fcString, birthString, type);
                error.setText("Registrazione completata!");
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
