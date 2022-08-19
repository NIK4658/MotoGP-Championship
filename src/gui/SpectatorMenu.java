package gui;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;

public class SpectatorMenu extends JPanel implements Menu{

    private static final long serialVersionUID = 1L;
    private final MenuManager frame;

    public SpectatorMenu(final MenuManager frame) {
        this.frame = frame;
        this.setLayout(new BorderLayout());
        this.setPreferredSize(frame.getSizeMenu());
        JPanel northPanel = new JPanel();
        JPanel southPanel = new JPanel();
        JPanel eastPanel = new JPanel();
        JPanel westPanel = new JPanel();
        northPanel.setPreferredSize(new Dimension(frame.getWidthMenu()/20, frame.getHeightMenu()/20));
        southPanel.setPreferredSize(new Dimension(frame.getWidthMenu()/20, frame.getHeightMenu()/20));
        eastPanel.setPreferredSize(new Dimension(frame.getWidthMenu()/25, frame.getHeightMenu()/25));
        westPanel.setPreferredSize(new Dimension(frame.getWidthMenu()/25, frame.getHeightMenu()/25));
        
        JPanel center = new JPanel(new BorderLayout());
        center.setOpaque(false);

        JPanel centerwest = new JPanel(new BorderLayout());

        JButton menu = new JButton("Menu Principale");
        menu.setPreferredSize(new Dimension(frame.getWidthMenu()/20, frame.getHeightMenu()/10));
        menu.setFont(new Font("Arial", Font.PLAIN, frame.getWidthMenu() / 50));
        centerwest.add(menu, BorderLayout.NORTH);
        JPanel listOperations = new JPanel(new GridBagLayout());
        JButton viewOps = new JButton("Visualizza Operazioni");
        JButton register = new JButton("Registrazione Spettatore");
        JButton shop = new JButton("Acquisto Biglietto");

        viewOps.setPreferredSize(new Dimension(frame.getWidthMenu()/7, frame.getHeightMenu()/15));
        register.setPreferredSize(new Dimension(frame.getWidthMenu()/7, frame.getHeightMenu()/15));
        shop.setPreferredSize(new Dimension(frame.getWidthMenu()/7, frame.getHeightMenu()/15));

        listOperations.add(viewOps, new MyGridBagConstraints(0, 0, new Insets(0,0,0,0), GridBagConstraints.NONE));
        listOperations.add(register, new MyGridBagConstraints(0, 1, new Insets(0,0,0,0), GridBagConstraints.NONE));
        listOperations.add(shop, new MyGridBagConstraints(0, 2, new Insets(0,0,0,0), GridBagConstraints.NONE));
        
        listOperations.setPreferredSize(new Dimension(frame.getWidthMenu()/5, frame.getHeightMenu()/2));
        listOperations.setBackground(Color.red);
        centerwest.add(listOperations, BorderLayout.CENTER);

        center.add(centerwest, BorderLayout.WEST);

        JPanel mainpage = new JPanel(new GridBagLayout());
        mainpage.setBackground(Color.green);
        center.add(mainpage, BorderLayout.CENTER);

        menu.addActionListener( e -> {
            frame.setAccessMenu();
        });
        this.add(center, BorderLayout.CENTER);
        this.add(northPanel, BorderLayout.NORTH);
        this.add(southPanel, BorderLayout.SOUTH);
        this.add(eastPanel, BorderLayout.EAST);
        this.add(westPanel, BorderLayout.WEST);


        this.setVisible(true);
    }

    @Override
    public JPanel getMenu() {
        return this;
    }
}
