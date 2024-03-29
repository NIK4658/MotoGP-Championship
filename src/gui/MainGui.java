package gui;

import java.awt.Dimension;
import java.awt.Frame;

import javax.swing.JFrame;

import database.DBConnection;

/**
 * The main gui that manages the menu.
 */
public class MainGui implements MenuManager {

    private final DBConnection con;
    private final JFrame frame;
    private final int widthMenu;
    private final int heightMenu;
    private final Dimension sizeMenu;

    /**
     * Create the main gui that manages the menu.
     */
    public MainGui(DBConnection con) {
        this.con = con;
        this.frame = new JFrame();
        this.widthMenu =  (Utilities.resize(1.5f)).width;
        this.heightMenu = (Utilities.resize(1.5f)).height;
        this.sizeMenu = new Dimension(this.widthMenu, this.heightMenu);
        this.frame.setSize(this.sizeMenu);
        this.frame.setResizable(false);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setTitle("MOTOGP CHAMPIONSHIP");
        this.frame.setLocationRelativeTo(null);
        this.setAccessMenu();
        this.frame.setVisible(true);
    }

    @Override
    public void setAccessMenu() {
        this.updateMenu(new AccessMenu(this));
    }

    @Override
    public void setSpectatorMenu() {
        this.updateMenu(new SpectatorMenus(this, this.con));
    }

    @Override
    public void setOperatorMenu() {
        this.updateMenu(new OperatorMenus(this, this.con));
    }


    @Override
    public Frame getFrame() {
        return this.frame;
    }

    @Override
    public int getWidthMenu() {
        return this.widthMenu;
    }

    @Override
    public int getHeightMenu() {
        return this.heightMenu;
    }

    @Override
    public Dimension getSizeMenu() {
        return this.sizeMenu;
    }
    

    private void updateMenu(final Menu menu) {
        this.frame.setContentPane(menu.getMenu());
        this.frame.pack();
        this.frame.revalidate();
    }

}
