package gui;

import javax.swing.JButton;
import javax.swing.JPanel;

public class OperatorMenu extends JPanel implements Menu{

    private static final long serialVersionUID = 1L;
    private final MenuManager frame;

    public OperatorMenu(final MenuManager frame) {
        this.frame = frame;
        this.setPreferredSize(frame.getSizeMenu());
        JButton menu = new JButton("Menu");
        menu.addActionListener( e -> {
            frame.setAccessMenu();
        });
        this.add(menu);
    }

    @Override
    public JPanel getMenu() {
        return this;
    }
}