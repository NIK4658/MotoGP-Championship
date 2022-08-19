package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
//import view.menu.access.Access.AccessType;


/**
 * Initial login GUI.
 */
public class AccessPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private static final int RATIOTITLEFONT = 6;
    private static final int RATIOTITLEAREAY = 10;
    private static final int RATIOBTNAREAX = 2;
    private static final int RATIOBTNAREAY = 15;
    private static final int RATIOBTNFONT = 17;
    private static final int SPACINGTITLE = 60;
    private static final int SPACINGBTN = 10;
    
    /**
     * Constructor of the class that generates the JPanel.
     * 
     * @param access
     * @param dim           Dimension of the window.
     * @param accessType    Enum that defines whether access is login or registration.
     * @param al            ActionListener.
     */
    public AccessPanel(final Access access, final Dimension dim) {
        this.setLayout(new GridBagLayout());
        this.setBackground(new Color(68, 87, 96));
        this.setPreferredSize(dim);
        final JLabel title = new JLabel("ACCESSO" , SwingConstants.CENTER);                 
        final JButton spettatoriBtn;
        final JButton autorizzatiBtn;
        final ArrayList<JComponent> list = new ArrayList<>();
        spettatoriBtn = new JButton("Spettatori");
        autorizzatiBtn = new JButton("Autorizzati");
        list.add(spettatoriBtn);
        list.add(autorizzatiBtn);
        final int dimX = dim.width;
        final int dimY = dim.height;
        title.setForeground(Color.WHITE);
        title.setPreferredSize(new Dimension(dimX, dimY / RATIOTITLEAREAY));
        title.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, dimX / RATIOTITLEFONT));
        final GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(0, 0, SPACINGTITLE, 0);
        this.add(title, c);
        // Modifiche generali
        int i = 1;
        c.insets = new Insets(0, 0, SPACINGBTN, 0);
        for (final JComponent jc : list) {
            jc.setPreferredSize(new Dimension(dimX / RATIOBTNAREAX, dimY / RATIOBTNAREAY));
            jc.setFont(new Font("Arial", Font.PLAIN, dimX / RATIOBTNFONT));
            jc.setForeground(Color.black);
            c.gridy = i;
            this.add(jc, c);
            i++;
        }
        autorizzatiBtn.addActionListener(e -> {
            access.OperatorAccess();
        });

        spettatoriBtn.addActionListener(e -> {
            access.SpectatorAccess();
        });
    }
}
