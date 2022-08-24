package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Starting panel of the program.
 */
public class AccessMenu extends JPanel implements Access, Menu {

    private static final long serialVersionUID = 1L;
    private final MenuManager frame;
    
    /**
     * Main Costructor.
     * 
     * @param frame Frame of the window.
     * @param account AccountManager useful to manage user data.
     */
    public AccessMenu(final MenuManager frame) {
        this.setLayout(new BorderLayout());
        this.frame = frame;
        // Zona di destra
        final Dimension dimImg = new Dimension(frame.getWidthMenu() * 2 / 3, frame.getHeightMenu());
        final Image img = new ImageIcon("res/img/backgrounds/motogpbg2.png").getImage();
        final Image imgScaled = img.getScaledInstance(dimImg.width, dimImg.height, Image.SCALE_DEFAULT);
        this.add(new JLabel(new ImageIcon(imgScaled)), BorderLayout.EAST);
        // Zona di sinistra
        final AccessPanel accspanel = new AccessPanel(this, new Dimension(frame.getWidthMenu() * 1 / 3, frame.getHeightMenu()));
        this.add(accspanel, BorderLayout.WEST);
        this.setFocusable(true);
    }

    @Override
    public JPanel getMenu() {
        return this;
    }

    @Override
    public void SpectatorAccess() {
        this.frame.setSpectatorMenu();
    }

    @Override
    public void OperatorAccess() {
        this.frame.setOperatorMenu(); 
    }

}
