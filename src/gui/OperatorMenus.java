package gui;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Operations.AssegnaComponente;
import Operations.AssegnaCostruttore;
import Operations.CampionatoCostruttori;
import Operations.CampionatoPiloti;
import Operations.ClassificaGare;
import Operations.IscriviTeam;
import Operations.RegisterAutodrome;
import Operations.RegisterChampionship;
import Operations.RegisterComponent;
import Operations.RegisterConstructor;
import Operations.RegisterRace;
import Operations.RegisterTeam;
import Operations.StoricoTeam;
import Operations.TempoArrivo;
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

public class OperatorMenus extends JPanel implements Menu{

    private static final long serialVersionUID = 1L;
    private final MenuManager frame;
    List<JComponent> list = new ArrayList<JComponent>();
    private final Dimension Paneldimension;

    public OperatorMenus(final MenuManager frame, final DBConnection con) {
        this.frame = frame;
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
        JButton newTeam = new JButton("Nuovo TEAM");
        JButton newPil = new JButton("Nuovo Pilota");
        JButton newTelem = new JButton("Nuovo Telemetrista");
        JButton newGomm = new JButton("Nuovo Gommista");
        JButton newIng = new JButton("Nuovo Ingegnere");
        JButton newCostr = new JButton("Nuovo Costruttore");
        JButton newAutodr = new JButton("Nuovo Autodromo");
        JButton newGara = new JButton("Nuova Gara");
        JButton AssegnaComp = new JButton("Assegna Componente");
        JButton assegnCostr = new JButton("Assegna Costruttore");
        JButton iscriviTeam = new JButton("Iscrivi Team");
        JButton newCamp = new JButton("Nuovo Campionato");
        JButton newGaraCorsa = new JButton("Registra Tempo di Arrivo");
        JButton classifiche = new JButton("Classifiche Singole gare");
        JButton campPiloti = new JButton("Class. Campionato Piloti");
        JButton campCostruttori = new JButton("Class. Campionato Costruttori");
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
        list.add(AssegnaComp);
        list.add(assegnCostr);
        list.add(iscriviTeam);
        list.add(newCamp);
        list.add(newGaraCorsa);
        list.add(classifiche);
        list.add(campPiloti);
        list.add(campCostruttori);
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
        CardPanel.add(new RegisterComponent(this.Paneldimension, con, ComponentType.PILOTI), "Piloti");
        CardPanel.add(new RegisterComponent(this.Paneldimension, con, ComponentType.GOMMISTI), "Gommisti");
        CardPanel.add(new RegisterComponent(this.Paneldimension, con, ComponentType.TELEMETRISTI), "Telemetristi");
        CardPanel.add(new RegisterComponent(this.Paneldimension, con, ComponentType.INGEGNERI), "Ingegneri");
        CardPanel.add(new RegisterTeam(this.Paneldimension, con), "Team");
        CardPanel.add(new RegisterConstructor(this.Paneldimension, con), "Costruttore");
        CardPanel.add(new RegisterAutodrome(this.Paneldimension, con), "Autodromo");
        CardPanel.add(new RegisterChampionship(this.Paneldimension, con), "Campionato");
        CardPanel.add(new RegisterRace(this.Paneldimension, con), "Gara");
        CardPanel.add(new IscriviTeam(this.Paneldimension, con), "IscriviTeam");
        CardPanel.add(new AssegnaCostruttore(this.Paneldimension, con), "AssegnaCostruttori");
        CardPanel.add(new TempoArrivo(this.Paneldimension, con), "TempoArrivo");
        CardPanel.add(new ClassificaGare(this.Paneldimension, con), "ClassificaGare");
        CardPanel.add(new CampionatoPiloti(this.Paneldimension, con), "ClassificaCampionatoPiloti");
        CardPanel.add(new CampionatoCostruttori(this.Paneldimension, con), "ClassificaCampionatoCostruttori");
        CardPanel.add(new StoricoTeam(this.Paneldimension, con), "StoricoTeam");
        viewOps.setEnabled(false);
        //Adding Cardlayout to mainpage.
        mainpage.add(CardPanel);

        //Switch in database view.
        viewOps.addActionListener( e -> {
            CardPanel.add(con.FillPane(this.Paneldimension), "Schede");
            card.show(CardPanel, "Schede");
            EnableButtons();
            viewOps.setEnabled(false);
        });

        storicoTeam.addActionListener( e -> {
            card.show(CardPanel, "StoricoTeam");
            EnableButtons();
            storicoTeam.setEnabled(false);
        });

        campCostruttori.addActionListener( e -> {
            card.show(CardPanel, "ClassificaCampionatoCostruttori");
            EnableButtons();
            campCostruttori.setEnabled(false);
        });

        campPiloti.addActionListener( e -> {
            card.show(CardPanel, "ClassificaCampionatoPiloti");
            EnableButtons();
            campPiloti.setEnabled(false);
        });

        newGaraCorsa.addActionListener( e -> {
            card.show(CardPanel, "TempoArrivo");
            EnableButtons();
            newGaraCorsa.setEnabled(false);
        });

        classifiche.addActionListener( e -> {
            card.show(CardPanel, "ClassificaGare");
            EnableButtons();
            classifiche.setEnabled(false);
        });

        AssegnaComp.addActionListener( e -> {
            CardPanel.add(new AssegnaComponente(this.Paneldimension, con), "Assegna Componente");
            card.show(CardPanel, "Assegna Componente");
            EnableButtons();
            AssegnaComp.setEnabled(false);
        });

        assegnCostr.addActionListener( e -> {
            card.show(CardPanel, "AssegnaCostruttori");
            EnableButtons();
            assegnCostr.setEnabled(false);
        });

        iscriviTeam.addActionListener( e -> {
            card.show(CardPanel, "IscriviTeam");
            EnableButtons();
            iscriviTeam.setEnabled(false);
        });

        newGara.addActionListener( e -> {;
            card.show(CardPanel, "Gara");
            EnableButtons();
            newGara.setEnabled(false);
        });

        newCamp.addActionListener( e -> {
            card.show(CardPanel, "Campionato");
            EnableButtons();
            newCamp.setEnabled(false);
        });

        newAutodr.addActionListener( e -> {
            card.show(CardPanel, "Autodromo");
            EnableButtons();
            newAutodr.setEnabled(false);
        });

        newTeam.addActionListener( e -> {
            card.show(CardPanel, "Team");
            EnableButtons();
            newTeam.setEnabled(false);
        });

        newCostr.addActionListener( e -> {
            card.show(CardPanel, "Costruttore");
            EnableButtons();
            newCostr.setEnabled(false);
        });

        newPil.addActionListener(e ->{
            card.show(CardPanel, "Piloti");
            EnableButtons();
            newPil.setEnabled(false);
        });

        newIng.addActionListener(e ->{
            card.show(CardPanel, "Ingegneri");
            EnableButtons();
            newIng.setEnabled(false);
        });

        newTelem.addActionListener(e ->{
            card.show(CardPanel, "Telemetristi");
            EnableButtons();
            newTelem.setEnabled(false);
        });

        newGomm.addActionListener(e ->{
            card.show(CardPanel, "Gommisti");
            EnableButtons();
            newGomm.setEnabled(false);
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

    public void EnableButtons() {
        for(JComponent c : this.list) {
            c.setEnabled(true);
        }
    }

}
