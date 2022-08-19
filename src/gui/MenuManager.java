package gui;

import java.awt.Dimension;
import java.awt.Frame;
//import model.account.AccountManager;
//import view.menu.games.Game.Games;

/**
 * Menumanager manages the various menus and provides some properties of the menu.
 */
public interface MenuManager {
    
    /**
     * Set the access menu which must be accessed with credential.
     * 
     * @param account
     * 
     */
    void setAccessMenu();

    /**
     * Set the Spectator menu which is set after login .
     *
     * 
     */
    void setSpectatorMenu();

    /**
     * Set the Operator menu which is set after login .
     * 
     * 
     */
    void setOperatorMenu();
    
    /**
     * Returns the main frame.
     * 
     * @return the frame of menu manager
     */
    Frame getFrame();
 
    /**
     * Returns the width of menu.
     * 
     * @return returns the width of menu
     */
    int getWidthMenu();
    
    /**
     * Returns the height of menu.
     * 
     * @return returns the height of menu
     */
    int getHeightMenu();
    
    /**
     * Returns the size of menu.
     * 
     * @return returns the size of menu
     */
    Dimension getSizeMenu();
    
}
