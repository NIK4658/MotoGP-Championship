package start;

import database.DBConnection;
import gui.MainGui;

/**
 * Starts the application.
 */
public final class ApplicationStart {
    public static void main(final String[] args) {
        DBConnection con = new DBConnection();
        new MainGui(con);
    }
}
