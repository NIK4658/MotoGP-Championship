package gui;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Operations.RegisterComponent;
import database.DBConnection;
import database.DBConnection.ComponentType;

import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;

public class SpectatorMenu extends JPanel implements Menu{

    private static final long serialVersionUID = 1L;
    private final MenuManager frame;
    private final Dimension Paneldimension;

    public SpectatorMenu(final MenuManager frame, final DBConnection con) {
        this.frame = frame;
        this.Paneldimension = new Dimension((int)(frame.getWidthMenu()/1.39),(int)(frame.getHeightMenu()/1.112));
        this.setLayout(new BorderLayout());
        this.setPreferredSize(frame.getSizeMenu());
        //Margin around the main panel
        JPanel northPanel = new JPanel();
        JPanel southPanel = new JPanel();
        JPanel eastPanel = new JPanel();
        JPanel westPanel = new JPanel();
        List<JComponent> list = new ArrayList<JComponent>();
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
        JButton newTeam = new JButton("Nuovo TEAM");
        JButton newPil = new JButton("Nuovo Pilota");
        JButton newTelem = new JButton("Nuovo Telemetrista");
        JButton newGomm = new JButton("Nuovo Gommista");
        JButton newIng = new JButton("Nuovo Ingegnere");
        JButton newCostr = new JButton("Nuovo Costruttore");
        JButton newAutodr = new JButton("Nuovo Autodromo");
        JButton newGara = new JButton("Nuova Gara");
        JButton sostComp = new JButton("Sostituisci Componente");
        JButton assegnCostr = new JButton("Assegna Costruttore");
        JButton iscriviTeam = new JButton("Iscrivi Team");
        JButton newCamp = new JButton("Nuovo Campionato");
        JButton newGaraCamp = new JButton("<html>Aggiungi Gara ad un </br>Campionato</html>");
        JButton classifiche = new JButton("Classifiche");
        JButton storicoTeam = new JButton("Storico Team");


        //JButton register = new JButton("Registrazione Spettatore");
        //JButton shop = new JButton("Acquisto Biglietto");
        list = new ArrayList<JComponent>();
        list.add(viewOps);
        list.add(newTeam);
        list.add(newPil);
        list.add(newTelem);
        list.add(newGomm);
        list.add(newIng);
        list.add(newCostr);
        list.add(newAutodr);
        list.add(newGara);
        list.add(sostComp);
        list.add(assegnCostr);
        list.add(iscriviTeam);
        list.add(newCamp);
        list.add(newGaraCamp);
        list.add(classifiche);
        list.add(storicoTeam);

        //list.add(register);
        //list.add(shop);
        int i=0;
        //Formatting side buttons.
        for(JComponent c : list) {
            //c.setMinimumSize(new Dimension(frame.getWidthMenu()/7, frame.getHeightMenu()/15));
            c.setPreferredSize(new Dimension(frame.getWidthMenu()/5, frame.getHeightMenu()/24));
            c.setFont(new Font("Arial", Font.BOLD, frame.getWidthMenu() / 80));
            listOperations.add(c, new MyGridBagConstraints(0, i, new Insets(0,0,0,0), GridBagConstraints.NONE));
            i++;
        }

        newGaraCamp.setPreferredSize(new Dimension(frame.getWidthMenu()/5, frame.getHeightMenu()/12));
        newGaraCamp.setHorizontalTextPosition(SwingConstants.CENTER);

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
        String[] labels = {"Nome", "Cognome", "Codice Fiscale", "Data di Nascita"};
        CardPanel.add(new RegisterComponent(this.Paneldimension, con, ComponentType.SPETTATORI, labels), "Spettatori");
        CardPanel.add(new RegisterComponent(this.Paneldimension, con, ComponentType.PILOTI, labels), "Piloti");
        CardPanel.add(new RegisterComponent(this.Paneldimension, con, ComponentType.GOMMISTI, labels), "Gommisti");
        CardPanel.add(new RegisterComponent(this.Paneldimension, con, ComponentType.TELEMETRISTI, labels), "Telemetristi");
        CardPanel.add(new RegisterComponent(this.Paneldimension, con, ComponentType.INGEGNERI, labels), "Ingegneri");

        //Adding Cardlayout to mainpage.
        mainpage.add(CardPanel);

        //Switch in database view.
        viewOps.addActionListener( e -> {
            CardPanel.add(con.FillPane(this.Paneldimension), "Schede");
            card.show(CardPanel, "Schede");
        });


        newPil.addActionListener(e ->{
            card.show(CardPanel, "Piloti");
        });

        newIng.addActionListener(e ->{
            card.show(CardPanel, "Ingegneri");
        });

        newTelem.addActionListener(e ->{
            card.show(CardPanel, "Telemetristi");
        });

        newGomm.addActionListener(e ->{
            card.show(CardPanel, "Gommisti");
        });

        //Switch in registration view.
        //register.addActionListener( e -> {
        //    card.show(CardPanel, "Spettatori");
        //});

        //Switch in ticket view.
        //shop.addActionListener( e -> {
        //    card.show(CardPanel, "biglietto");
        //});

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


}
