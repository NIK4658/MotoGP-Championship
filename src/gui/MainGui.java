package gui;

import java.awt.Dimension;
import java.awt.Frame;
import javax.swing.JFrame;
//import model.account.AccountManager;
//import model.account.AdvancedAccountManagerImpl;
//import view.Utilities;
//import view.menu.AccessMenu;
//import view.menu.AccountMenu;
//import view.menu.GeneralGui;
//import view.menu.MainMenu;
//import view.menu.Menu;
//import view.menu.games.Game.Games;
//import view.menu.games.MergedGame;

/**
 * The main gui that manages the menu.
 */
public class MainGui implements MenuManager {

    private final JFrame frame;
    private final int widthMenu;
    private final int heightMenu;
    private final Dimension sizeMenu;

    /**
     * Create the main gui that manages the menu.
     */
    public MainGui() {
        this.frame = new JFrame();
        this.widthMenu =  (Utilities.resize(1.5f)).width;
        this.heightMenu = (Utilities.resize(1.5f)).height;
        this.sizeMenu = new Dimension(this.widthMenu, this.heightMenu);
        this.frame.setSize(this.sizeMenu);
        this.frame.setResizable(false);
        System.out.println("Width: " + this.widthMenu + " Height: " + this.heightMenu);
        System.out.println("frame: "+this.frame.getSize());
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setTitle("MOTOGP CHAMPIONSHIP");
        //this.frame.setIconImage(Utilities.getImage("img/logo/gdclogo3.png"));
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
        this.updateMenu(new SpectatorMenu(this));
    }

    @Override
    public void setOperatorMenu() {
        this.updateMenu(new OperatorMenu(this));
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
