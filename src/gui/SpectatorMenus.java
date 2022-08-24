package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

import Operations.GenerateTicket;
import Operations.RegisterComponent;
import database.DBConnection;
import database.DBConnection.ComponentType;

public class SpectatorMenus extends JPanel implements Menu{

    private static final long serialVersionUID = 1L;
    List<JComponent> list = new ArrayList<JComponent>();
    private final Dimension Paneldimension;

    public SpectatorMenus(final MenuManager frame, final DBConnection con) {
        this.Paneldimension = new Dimension((int)(frame.getWidthMenu()/1.39),(int)(frame.getHeightMenu()/1.112));
        this.setLayout(new BorderLayout());
        this.setPreferredSize(frame.getSizeMenu());
        //Margin around the main panel
        JPanel northPanel = new JPanel();
        JPanel southPanel = new JPanel();
        JPanel eastPanel = new JPanel();
        JPanel westPanel = new JPanel();
        list = new ArrayList<JComponent>();
        list.add(northPanel);
        list.add(southPanel);
        list.add(eastPanel);
        list.add(westPanel);
        for(JComponent c : list) {
            c.setBackground(new Color(68, 87, 96));
            c.setPreferredSize(new Dimension(frame.getWidthMenu()/20, frame.getHeightMenu()/20));
        }
        eastPanel.setPreferredSize(new Dimension(frame.getWidthMenu()/25, frame.getHeightMenu()/25));
        westPanel.setPreferredSize(new Dimension(frame.getWidthMenu()/25, frame.getHeightMenu()/25));
        this.add(northPanel, BorderLayout.NORTH);
        this.add(southPanel, BorderLayout.SOUTH);
        this.add(eastPanel, BorderLayout.EAST);
        this.add(westPanel, BorderLayout.WEST);
        //Main panel
        JPanel center = new JPanel(new BorderLayout());
        center.setBackground(new Color(68, 87, 96));
        center.setOpaque(true);
        //Container of main menu button and list of operations
        JPanel centerwest = new JPanel(new BorderLayout());
        JButton menu = new JButton("Menu Principale");
        menu.setPreferredSize(new Dimension(frame.getWidthMenu()/20, frame.getHeightMenu()/10));
        menu.setFont(new Font("Arial", Font.PLAIN, frame.getWidthMenu() / 50));
        centerwest.add(menu, BorderLayout.NORTH);
        JPanel listOperations = new JPanel(new GridBagLayout());

        JButton viewOps = new JButton("Visualizza Schede");
        JButton newSpett = new JButton("Iscrivi Spettatore");
        JButton newTicket = new JButton("Genera biglietto");
        list = new ArrayList<JComponent>();
        list.add(viewOps);
        list.add(newSpett);
        list.add(newTicket);
        int i=0;
        //Formatting side buttons.
        for(JComponent c : list) {
            //c.setMinimumSize(new Dimension(frame.getWidthMenu()/7, frame.getHeightMenu()/15));
            c.setPreferredSize(new Dimension(frame.getWidthMenu()/6, frame.getHeightMenu()/24));
            c.setFont(new Font("Arial", Font.BOLD, frame.getWidthMenu() / 80));
            listOperations.add(c, new MyGridBagConstraints(0, i, new Insets(0,0,0,0), GridBagConstraints.NONE));
            i++;
        }

        listOperations.setPreferredSize(new Dimension(frame.getWidthMenu()/5, frame.getHeightMenu()/2));
        listOperations.setOpaque(false);
        centerwest.setOpaque(false);
        centerwest.add(listOperations, BorderLayout.CENTER);
        //Adding main menu button and list of operations to main panel
        center.add(centerwest, BorderLayout.WEST);
        //Mainpage of the program, right side.
        JPanel mainpage = new JPanel(new GridBagLayout());
        mainpage.setOpaque(true);
        mainpage.setBackground(new Color(68, 87, 96));
        //Creating Cardlayout for multiple pages.
        CardLayout card = new CardLayout();
        //Container for the Cardlayout.
        JPanel CardPanel = new JPanel(card);
        CardPanel.setOpaque(false);
        CardPanel.setPreferredSize(this.Paneldimension);
        //Adding database view.
        CardPanel.add(con.FillPane(this.Paneldimension), "Schede");
        //Adding register fan page.
        CardPanel.add(new RegisterComponent(this.Paneldimension, con, ComponentType.SPETTATORI), "Spettatori");
        CardPanel.add(new GenerateTicket(this.Paneldimension, con), "Biglietto");
        viewOps.setEnabled(false);
        //Adding Cardlayout to mainpage.
        mainpage.add(CardPanel); 
        card.show(CardPanel, "Schede");
        
        //Switch in database view.
        viewOps.addActionListener( e -> {
            CardPanel.add(con.FillPane(this.Paneldimension), "Schede");
            card.show(CardPanel, "Schede");
            EnableButtons();
            viewOps.setEnabled(false);
        });


        newTicket.addActionListener(e -> {
            card.show(CardPanel, "Biglietto");
            EnableButtons();
            newTicket.setEnabled(false);
        });

        newSpett.addActionListener(e -> {
            card.show(CardPanel, "Spettatori");
            EnableButtons();
            newSpett.setEnabled(false);
        });

        
        //Go to main menu.
        menu.addActionListener( e -> {
            frame.setAccessMenu();
        });
        center.add(mainpage, BorderLayout.CENTER);
        this.add(center, BorderLayout.CENTER);
        this.setVisible(true);
    }

    @Override
    public JPanel getMenu() {
        return this;
    }

    public void EnableButtons() {
        for(JComponent c : this.list) {
            c.setEnabled(true);
        }
    }

}
