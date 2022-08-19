package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * Menu principale.
 */
public class MainMenu extends JPanel implements Menu {
	
	

    private static final long serialVersionUID = 1L;
    //private final MenuManager frame;
    
    
    private final Image img = Utilities.getImage("img/backgrounds/MainBG.jpg");

    /**
     * Costruttore.
     */
    public MainMenu(final MenuManager frame) {
        //this.frame = frame;
        this.setLayout(new BorderLayout());
        this.setPreferredSize(frame.getSizeMenu());
        final int width = frame.getWidthMenu();
        final int height = frame.getHeightMenu();
        final JPanel north = new JPanel(new GridBagLayout());
        final JPanel center = new JPanel(new GridBagLayout());
        center.setOpaque(false);
        north.setOpaque(false);
        north.setPreferredSize(new Dimension(width, height / 4));
        JButton accountman = new JButton("Account settings");
        accountman.setOpaque(true);
        accountman.setBorderPainted(false);
        accountman.setBackground(new Color(0, 153, 0));
        accountman.setForeground(Color.WHITE);
        this.add(accountman,BorderLayout.SOUTH);
        final JLabel title = new JLabel("GIOCHI DEL COLOSSO", SwingConstants.CENTER);
        title.setForeground(Color.WHITE);
        title.setPreferredSize(new Dimension(width - (width / 3 / 2), height / 10));
        title.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, width / 20));
        north.add(title);
        final JButton blackjack = new JButton();
        final JButton rouletteBase = new JButton();
        final JButton rouletteEuropean = new JButton();
        final JButton rouletteAmerican = new JButton();
        final JButton bacarat = new JButton();
        final Dimension buttonDimension = new Dimension(width / 5, height / 3); //eliminare magic numbers
        final Dimension buttonRouletteDimension = new Dimension(buttonDimension.width / 3, buttonDimension.height);
        final GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.insets = new Insets(0, 50, 0, 50);
        blackjack.setPreferredSize(buttonDimension);
        center.add(blackjack, c);
        rouletteAmerican.setPreferredSize(buttonRouletteDimension);
        c.gridx++;
        c.insets = new Insets(0, 50, 0, 0);
        center.add(rouletteAmerican, c);
        rouletteBase.setPreferredSize(buttonRouletteDimension);
        c.gridx++;
        c.insets = new Insets(0, 0, 0, 0);
        center.add(rouletteBase, c);
        rouletteEuropean.setPreferredSize(buttonRouletteDimension);
        c.gridx++;
        c.insets = new Insets(0, 0, 0, 50);
        center.add(rouletteEuropean, c);
        bacarat.setPreferredSize(buttonDimension);
        c.gridx++;
        c.insets = new Insets(0, 50, 0, 50);
        center.add(bacarat, c);
        Image img, imgScaled;
        img = Utilities.getImage("img/backgrounds/bj.jpg");
        imgScaled = img.getScaledInstance(buttonDimension.width, buttonDimension.height, Image.SCALE_SMOOTH);
        blackjack.setIcon(new ImageIcon((imgScaled)));
        img = Utilities.getImage("img/backgrounds/BaseRoulette.png");
        imgScaled = img.getScaledInstance(buttonRouletteDimension.width, buttonRouletteDimension.height, Image.SCALE_SMOOTH);
        rouletteBase.setIcon(new ImageIcon((imgScaled)));
        img = Utilities.getImage("img/backgrounds/EuropeanRoulette.png");
        imgScaled = img.getScaledInstance(buttonRouletteDimension.width, buttonRouletteDimension.height, Image.SCALE_SMOOTH);
        rouletteEuropean.setIcon(new ImageIcon((imgScaled)));
        img = Utilities.getImage("img/backgrounds/AmericanRoulette.png");
        imgScaled = img.getScaledInstance(buttonRouletteDimension.width, buttonRouletteDimension.height, Image.SCALE_SMOOTH);
        rouletteAmerican.setIcon(new ImageIcon((imgScaled)));
        img = Utilities.getImage("img/backgrounds/bac.jpg");
        imgScaled = img.getScaledInstance(buttonDimension.width, buttonDimension.height, Image.SCALE_SMOOTH);
        bacarat.setIcon(new ImageIcon((imgScaled)));
        this.add(north, BorderLayout.NORTH);
        this.add(center, BorderLayout.CENTER);
    }

    @Override
    public JPanel getMenu() {
        return this;
    }
    
    @Override
    protected void paintComponent(final Graphics g) {
        super.paintComponent(g);
        g.drawImage(this.img, 0, 0, getWidth(), getHeight(), null);
    }
    
}