package database;

import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DBConnection {

    public enum ComponentType {
        PILOTI, INGEGNERI, GOMMISTI, TELEMETRISTI, SPETTATORI
    }

    Statement statement=null;
    ResultSet resultSet=null;

    public DBConnection(){
        try {
            String url = "jdbc:mysql://localhost:3306/motogpchampionship";
            String user = "root";
            String password = "";
            Connection con = DriverManager.getConnection(url, user, password);
            String query = "SELECT * FROM piloti";
            this.statement = con.createStatement();
            this.resultSet = this.statement.executeQuery(query);

            while(this.resultSet.next()){
                System.out.println(this.resultSet.getString("nome"));
            }

            /*
            DefaultTableModel model = new DefaultTableModel(data, columns);
            JTable table = new JTable(model);
            table.setShowGrid(true);
            table.setShowVerticalLines(true);
            JScrollPane pane = new JScrollPane(table);
            JFrame f = new JFrame("Populate JTable from Database");
            JPanel panel = new JPanel();
            panel.add(pane);
            f.add(panel);
            f.setSize(500, 250);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setVisible(true);
            */ 
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public Statement getStatement(){
        return this.statement;
    }

    public ResultSet getResultSet(){
        return this.resultSet;
    }

    public void getSomething(){
        String query = "SELECT * FROM piloti";
        try{
            ResultSet rs = this.getStatement().executeQuery(query);

            while(rs.next()){
                System.out.println(rs.getString("nome"));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }


    public DefaultTableModel buildTableModel(ResultSet rs) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();
        // names of columns
        Vector<String> columnNames = new Vector<String>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }
        // data of the table
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<Object>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(rs.getObject(columnIndex));
            }
            data.add(vector);
        }
        return new DefaultTableModel(data, columnNames);
    }


    public JTabbedPane FillPane(final Dimension dim) {
        
        try{
            JTabbedPane tabbedPane = new JTabbedPane();
            tabbedPane.setPreferredSize(dim);
            //String[] tables = {"Autodromi", "Gare", "Spettatori"};

            String[] tables = {"AGGREGAZIONEGOMMISTI", "AGGREGAZIONEINGEGNERI", "AGGREGAZIONEPILOTI", "AGGREGAZIONETELEMETRISTI" , "AUTODROMI",
             "BIGLIETTI", "CAMPIONATI", "CORRE", "COSTRUTTORI", "FORNITORI", "GARE", "GOMMISTI", "INGEGNERIMECCANICI", "ISCRIZIONI", "PILOTI", "SPETTATORI", "TEAM", "TELEMETRISTI"};

            for(String s : tables){
                String query = "SELECT * FROM " + s;
                ResultSet rs = this.getStatement().executeQuery(query);
                JTable table = new JTable(this.buildTableModel(rs));
                table.setFont(new Font("Arial", Font.PLAIN, (int)dim.getWidth() / 70));
                JScrollPane scrollPane = new JScrollPane(table);
                tabbedPane.setFont(new Font("Arial", Font.PLAIN, (int) dim.getWidth() / 60));
                table.setEnabled(false);
                tabbedPane.addTab(s, scrollPane);
            }
            return tabbedPane;

        } catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void registerComponent(String nameString, String surnameString, String fcString, String birthString, ComponentType component) {
        String query = "INSERT INTO " + component+" (nome, cognome, codiceFiscale, dataNascita) VALUES ('"+nameString+"', '"+surnameString+"', '"+fcString+"', '"+birthString+"')";
        try{
            this.getStatement().executeUpdate(query);
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean validDate(final String date){
        String[] dateSplit = date.split("-");
        if(dateSplit.length != 3){
            return false;
        }
        if(dateSplit[0].length() != 4 || dateSplit[1].length() != 2 || dateSplit[2].length() != 2){
            return false;
        }
        if(Integer.parseInt(dateSplit[0]) < 1900 || Integer.parseInt(dateSplit[0]) > 2022){
            return false;
        }
        if(Integer.parseInt(dateSplit[1]) < 1 || Integer.parseInt(dateSplit[1]) > 12){
            return false;
        }
        if(Integer.parseInt(dateSplit[2]) < 1 || Integer.parseInt(dateSplit[2]) > 31){
            return false;
        }
        return true;
    }

}

