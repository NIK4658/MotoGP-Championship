package database;

import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
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


    public DefaultTableModel buildTableModel(ResultSet resultSet2) throws SQLException {
        ResultSetMetaData metaData = resultSet2.getMetaData();
        // names of columns
        Vector<String> columnNames = new Vector<String>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }
        // data of the table
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (resultSet2.next()) {
            Vector<Object> vector = new Vector<Object>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(resultSet2.getObject(columnIndex));
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

    public boolean registerComponent(String nameString, String surnameString, String fcString, String birthString, ComponentType component) {
        String query = "";
        if(component==ComponentType.INGEGNERI){
            query = "INSERT INTO ingegnerimeccanici (nome, cognome, codiceFiscale, dataNascita) VALUES ('"+nameString+"', '"+surnameString+"', '"+fcString+"', '"+birthString+"')";
        } else{
            query = "INSERT INTO " + component+" (nome, cognome, codiceFiscale, dataNascita) VALUES ('"+nameString+"', '"+surnameString+"', '"+fcString+"', '"+birthString+"')";
        }
        
        return executeQuery(query);
    }

    public boolean validDate(final String date){
        String[] dateSplit = date.split("-");
        if(dateSplit.length != 3){
            return false;
        }
        if(dateSplit[0].length() != 4 || dateSplit[1].length() != 2 || dateSplit[2].length() != 2){
            return false;
        }
        if(Integer.parseInt(dateSplit[0]) < 1900 || Integer.parseInt(dateSplit[0]) > 2030){
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

    public boolean registerTeam(final String nameString){
        String query = "INSERT INTO TEAM (nome) VALUES ('"+nameString+"')";
        return executeQuery(query);
    }

    public boolean RegisterConstructor(String nameString, String engineString) {
        String query = "INSERT INTO COSTRUTTORI (nome, TipoMotore) VALUES ('"+nameString+"', '"+engineString+"')";
        return executeQuery(query);
    }

    public boolean executeQuery(String query) {
        try{
            this.getStatement().executeUpdate(query);
            return true;
        } catch(SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean RegisterAutodrome(String nameString, String stateString, String numberSeatString) {
        String query = "INSERT INTO AUTODROMI (nome, Stato, NumeroPostiTotali) VALUES ('"+nameString+"', '"+stateString+"', '"+numberSeatString+"')";
        return executeQuery(query);
    }

    public boolean GenerateChampionship() {
        String query = "INSERT INTO CAMPIONATI () VALUES ()";
        return executeQuery(query);
    }

    public boolean registerRace(String yearString, String champString, String autodromeString, String dateString,
            String numberLapsString) {
        String query = "INSERT INTO GARE (Anno, CodiceCampionato, CodiceAutodromo, Data, NumeroGiri) VALUES ('"+yearString+"', '"+champString+"', '"+autodromeString+"', '"+dateString+"', '"+numberLapsString+"')";
        return executeQuery(query);
    }


    public String[] getChampID(){
        String[] champID = new String[100];
        String query = "SELECT CodiceCampionato FROM CAMPIONATI";
        int i=0;
        try{
            ResultSet rs = this.getStatement().executeQuery(query);
            while(rs.next()){
                champID[i] = rs.getString("CodiceCampionato");
                i++;
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return Arrays.copyOf(champID, i);
    }

    public String[] getAutodromoID() {
        String[] autodromoID = new String[100];
        String query = "SELECT CodiceAutodromo FROM AUTODROMI";
        int i=0;
        try{
            ResultSet rs = this.getStatement().executeQuery(query);
            while(rs.next()){
                autodromoID[i] = rs.getString("CodiceAutodromo");
                i++;
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return Arrays.copyOf(autodromoID, i);
    }

    public String[] getTeams() {
        String[] teams = new String[100];
        String query = "SELECT CodiceTeam FROM TEAM";
        int i=0;
        try{
            ResultSet rs = this.getStatement().executeQuery(query);
            while(rs.next()){
                teams[i] = rs.getString("CodiceTeam");
                i++;
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return Arrays.copyOf(teams, i); 
    }

    public String[] getComponentID(ComponentType selectedType) {
        String[] compID = new String[100];
        String query="";
        String columnlabel="";
        if(selectedType==ComponentType.PILOTI){
            query = "SELECT CodicePilota FROM piloti";
            columnlabel="CodicePilota";
        }else if(selectedType==ComponentType.GOMMISTI){
            query = "SELECT CodiceGommista FROM GOMMISTI";
            columnlabel="CodiceGommista";
        }else if(selectedType==ComponentType.TELEMETRISTI){
            query = "SELECT CodiceTelemetrista FROM TELEMETRISTI";
            columnlabel="CodiceTelemetrista";
        }else if(selectedType==ComponentType.INGEGNERI){
            query = "SELECT CodiceIngegnere FROM INGEGNERIMECCANICI";
            columnlabel="CodiceIngegnere";
        }else if(selectedType==ComponentType.SPETTATORI){
            query = "SELECT CodiceSpettatore FROM SPETTATORI";
            columnlabel="CodiceSpettatore";
        }
        int i=0;
        try{
            ResultSet rs = this.getStatement().executeQuery(query);
            while(rs.next()){
                compID[i] = rs.getString(columnlabel);
                i++;
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return Arrays.copyOf(compID, i); 
    }

    public boolean assegnaComponente(String typeString, String iDString, String teamString, String annoString) {
        String query="";
        if(typeString==ComponentType.PILOTI.name()){
            query = "INSERT INTO aggregazionepiloti (CodicePilota, CodiceTeam, Anno) VALUES ('"+iDString+"', '"+teamString+"', '"+annoString+"')";
        }else if(typeString==ComponentType.GOMMISTI.name()){
            query = "INSERT INTO aggregazioneGOMMISTI (CodiceGommista, CodiceTeam, Anno) VALUES ('"+iDString+"', '"+teamString+"', '"+annoString+"')";
        }else if(typeString==ComponentType.TELEMETRISTI.name()){
            query = "INSERT INTO aggregazioneTELEMETRISTI (CodiceTelemetrista, CodiceTeam, Anno) VALUES ('"+iDString+"', '"+teamString+"', '"+annoString+"')";
        }else if(typeString==ComponentType.INGEGNERI.name()){
            query = "INSERT INTO aggregazioneINGEGNERI (CodiceIngegnere, CodiceTeam, Anno) VALUES ('"+iDString+"', '"+teamString+"', '"+annoString+"')";
        }    
        return executeQuery(query);
    }

    public boolean iscriviTeam(String teamString, String champString) {
        String query = "INSERT INTO iscrizioni (CodiceTeam, CodiceCampionato) VALUES ('"+teamString+"', '"+champString+"')";
        return executeQuery(query);
    }

    public String[] getCostruttori() {
        String[] costruttori = new String[100];
        String query = "SELECT CodiceCostruttore FROM Costruttori";
        int i=0;
        try{
            ResultSet rs = this.getStatement().executeQuery(query);
            while(rs.next()){
                costruttori[i] = rs.getString("CodiceCostruttore");
                i++;
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return Arrays.copyOf(costruttori, i); 
    }


    public boolean AssegnaCostruttore(String teamString, String costruttString) {
        String query = "DELETE FROM fornitori WHERE codiceTeam = '"+teamString+"'";
        System.out.println(executeQuery(query));
        query = "INSERT INTO fornitori (CodiceCostruttore, CodiceTeam) VALUES ('"+costruttString+"', '"+teamString+"')";
        return executeQuery(query);
    }

    public boolean registraTempo(String idPilotaString, String tempoString, String CodiceCampionato, String CodiceAutodromo, String AnnoString) {
        String query = "INSERT INTO corre (Anno, CodiceCampionato, CodiceAutodromo, CodicePilota, TempoGara) VALUES ('"+AnnoString+"', '"+CodiceCampionato+"', '"+CodiceAutodromo+"', '"+idPilotaString+"', '"+tempoString+"')";
        return executeQuery(query);
    }

    public JTabbedPane getClassifica(Dimension dim, String champ, String autodromo, String anno) {
        String query = "WITH Classifica AS (SELECT corre.TempoGara as 'Tempo', corre.CodicePilota, ROW_NUMBER() OVER ( ORDER BY corre.TempoGara ASC ) AS 'Posizione' FROM corre WHERE corre.CodiceCampionato = "+champ+" AND corre.CodiceAutodromo = "+autodromo+" AND corre.Anno = "+anno+" ) SELECT Classifica.Posizione AS 'Posizione', CASE WHEN Classifica.Posizione = 1 THEN '25' WHEN Classifica.Posizione = 2 THEN '20' WHEN Classifica.Posizione = 3 THEN '16' WHEN Classifica.Posizione = 4 THEN '13' WHEN Classifica.Posizione <=15 THEN 16-Classifica.Posizione ELSE 0 END AS 'Punti', piloti.Nome AS 'Nome', piloti.Cognome AS 'Cognome', Classifica.Tempo AS 'Tempo Gara',  piloti.CodicePilota AS 'Codice Pilota' FROM Classifica INNER JOIN piloti ON piloti.CodicePilota = Classifica.codicePilota ORDER BY Classifica.Posizione ASC";
        try {
            JTabbedPane tabbedPane = new JTabbedPane();
            ResultSet rs = this.getStatement().executeQuery(query);
            JTable table = new JTable(this.buildTableModel(rs));
            table.setFont(new Font("Arial", Font.PLAIN, (int)dim.getWidth() / 70));
            table.setEnabled(false);
            JScrollPane scrollPane = new JScrollPane(table);
            tabbedPane.setFont(new Font("Arial", Font.PLAIN, (int) dim.getWidth() / 60));
            table.setEnabled(false);
            tabbedPane.addTab("Classifica", scrollPane);
            return tabbedPane;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new JTabbedPane();
    }

    public JTabbedPane getCampionatoPiloti(Dimension dim, String champ) {
        JTabbedPane tabbedPane = new JTabbedPane();
        Map<String, Integer> map = new HashMap<>();
        for(String id : this.getComponentID(ComponentType.PILOTI)){
            map.put(id, 0);
        }
        for (String autodromo : getAutodromoID() ){
            String query = "WITH Classifica AS (SELECT corre.TempoGara as 'Tempo', corre.CodicePilota, ROW_NUMBER() OVER ( ORDER BY corre.TempoGara ASC ) AS 'Posizione' FROM corre WHERE corre.CodiceCampionato = "+champ+" AND corre.CodiceAutodromo = "+autodromo+" ) SELECT Classifica.Posizione AS 'Posizione', CASE WHEN Classifica.Posizione = 1 THEN '25' WHEN Classifica.Posizione = 2 THEN '20' WHEN Classifica.Posizione = 3 THEN '16' WHEN Classifica.Posizione = 4 THEN '13' WHEN Classifica.Posizione <=15 THEN 16-Classifica.Posizione ELSE 0 END AS 'Punti', piloti.Nome AS 'Nome', piloti.Cognome AS 'Cognome', Classifica.Tempo AS 'Tempo Gara',  piloti.CodicePilota AS 'Codice Pilota' FROM Classifica INNER JOIN piloti ON piloti.CodicePilota = Classifica.codicePilota ORDER BY Classifica.Posizione ASC";
            try {
                resultSet = this.getStatement().executeQuery(query);
                JTable table = new JTable(this.buildTableModel(resultSet));   
                for(int i=0; i<table.getRowCount(); i++){
                    String id = table.getValueAt(i, 5).toString();
                    map.put(id, map.get(id)+ Integer.valueOf(table.getValueAt(i, 1).toString()));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return String.class;
                    case 1:
                        return String.class;
                    case 2:
                        return Integer.class;
                    default:
                        return Integer.class;
                }
            }
        };
        JTable table2 = new JTable(model); 
        table2.setFont(new Font("Arial", Font.PLAIN, (int)dim.getWidth() / 70));
        table2.setAutoCreateRowSorter(true);
        model.addColumn("Nome"); 
        model.addColumn("Cognome"); 
        model.addColumn("Punti"); 
        table2.getRowSorter().toggleSortOrder(2);
        table2.getRowSorter().toggleSortOrder(2);
        String query = "SELECT * FROM piloti";
        try {
            resultSet = this.getStatement().executeQuery(query);
            while(resultSet.next()){
                String id = resultSet.getString("CodicePilota");
                String nome = resultSet.getString("Nome");
                String cognome = resultSet.getString("Cognome");
                int punti = map.get(id);
                model.addRow(new Object[]{nome, cognome, (int)punti});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JScrollPane scrollPane = new JScrollPane(table2);
        tabbedPane.addTab("Classifica Piloti", scrollPane);
        return tabbedPane;
    }

    public JTabbedPane getCampionatoCostruttori(Dimension dim, String champ) {
        JTabbedPane tabbedPane = new JTabbedPane();
        Map<String, Integer> map = new HashMap<>();
        for(String id : this.getComponentID(ComponentType.PILOTI)){
            map.put(id, 0);
        }
        for (String autodromo : getAutodromoID() ){
            for(String codCostruttore : getCostruttori()){
                String query = "WITH Classifica AS ( SELECT corre.TempoGara as 'Tempo', corre.CodicePilota AS 'CodicePilota', costruttori.Nome 'Casa', piloti.Nome AS 'Nome', piloti.Cognome AS 'Cognome', costruttori.Nome 'Costruttore', costruttori.CodiceCostruttore AS 'CodiceCostruttore', ROW_NUMBER() OVER ( ORDER BY corre.TempoGara ASC ) AS 'Posizione' FROM corre INNER JOIN piloti ON piloti.CodicePilota = corre.CodicePilota INNER JOIN aggregazionepiloti ON piloti.CodicePilota = aggregazionepiloti.CodicePilota INNER JOIN team ON aggregazionepiloti.CodiceTeam = team.CodiceTeam INNER JOIN fornitori ON fornitori.CodiceTeam = team.CodiceTeam INNER JOIN costruttori ON fornitori.CodiceCostruttore = costruttori.CodiceCostruttore WHERE corre.CodiceCampionato = "+champ+" AND corre.CodiceAutodromo = "+autodromo+"), elencoArrivi AS ( SELECT Classifica.Posizione AS 'Posizione', CASE WHEN Classifica.Posizione = 1 THEN '25' WHEN Classifica.Posizione = 2 THEN '20' WHEN Classifica.Posizione = 3 THEN '16' WHEN Classifica.Posizione = 4 THEN '13' WHEN Classifica.Posizione <=15 THEN 16-Classifica.Posizione ELSE 0 END AS 'Punti', Classifica.Nome AS 'Nome', Classifica.Cognome AS 'Cognome', Classifica.Tempo AS 'Tempo Gara',  Classifica.CodicePilota AS 'Codice Pilota', Classifica.Casa 'Costruttore', Classifica.CodiceCostruttore AS 'CodiceCostruttore' FROM Classifica ORDER BY Classifica.Posizione ASC ) SELECT DISTINCT elencoarrivi.CodiceCostruttore AS 'CodiceCostruttore', elencoArrivi.Costruttore AS 'Costruttore', (SELECT SUM(punti) FROM elencoArrivi WHERE elencoarrivi.CodiceCostruttore = "+codCostruttore+") AS 'Punti' FROM elencoArrivi WHERE elencoarrivi.CodiceCostruttore = "+codCostruttore;
                try {
                    resultSet = this.getStatement().executeQuery(query);
                    JTable table = new JTable(this.buildTableModel(resultSet));   
                    try {
                        if(table.getValueAt(0, 0).toString() != null){ 
                            String id = table.getValueAt(0, 0).toString();
                            Double value = (Double)table.getValueAt(0, 2);
                            if(value==null){
                                map.put(id, map.get(id)+ 0);
                            } else {
                                map.put(id, map.get(id)+ value.intValue());
                            }
                        }    
                    } catch (Exception e) {
                    }                    
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return String.class;
                    case 1:
                        return Integer.class;
                    case 2:
                        return Integer.class;
                    default:
                        return Integer.class;
                }
            }
        };
        JTable table2 = new JTable(model); 
        table2.setFont(new Font("Arial", Font.PLAIN, (int)dim.getWidth() / 70));
        table2.setAutoCreateRowSorter(true);
        model.addColumn("Nome"); 
        model.addColumn("Punti"); 
        table2.getRowSorter().toggleSortOrder(1);
        table2.getRowSorter().toggleSortOrder(1);
        String query = "SELECT * FROM costruttori";
        try {
            resultSet = this.getStatement().executeQuery(query);
            int i=1;
            while(resultSet.next()){
                String id = resultSet.getString("CodiceCostruttore");
                String nome = resultSet.getString("Nome");
                int punti = map.get(id);
                model.addRow(new Object[]{nome, (int)punti});
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JScrollPane scrollPane = new JScrollPane(table2);
        tabbedPane.addTab("Classifica Costruttori", scrollPane);
        return tabbedPane;
    }

    public JTabbedPane getStoricoTeam(Dimension dim, String team, String anno, ComponentType selectedType) {
        String columnlabel="";
        String query = "";
        if(selectedType==ComponentType.PILOTI){
            columnlabel="CodicePilota";
            query = "SELECT "+columnlabel+" FROM aggregazionepiloti WHERE CodiceTeam = "+team+" AND anno = "+anno;
        }else if(selectedType==ComponentType.GOMMISTI){
            columnlabel="CodiceGommista";
            query = "SELECT "+columnlabel+" FROM aggregazionegommisti WHERE CodiceTeam = "+team+" AND anno = "+anno;
        }else if(selectedType==ComponentType.TELEMETRISTI){
            columnlabel="CodiceTelemetrista";
            query = "SELECT "+columnlabel+" FROM aggregazionetelemetristi WHERE CodiceTeam = "+team+" AND anno = "+anno;
        }else if(selectedType==ComponentType.INGEGNERI){
            columnlabel="CodiceIngegnere";
            query = "SELECT "+columnlabel+" FROM aggregazioneingegneri WHERE CodiceTeam = "+team+" AND anno = "+anno;
        }     

        try {
            JTabbedPane tabbedPane = new JTabbedPane();
            ResultSet rs = this.getStatement().executeQuery(query);
            JTable table = new JTable(this.buildTableModel(rs));
            table.setFont(new Font("Arial", Font.PLAIN, (int)dim.getWidth() / 70));
            table.setEnabled(false);
            JScrollPane scrollPane = new JScrollPane(table);
            tabbedPane.setFont(new Font("Arial", Font.PLAIN, (int) dim.getWidth() / 60));
            table.setEnabled(false);
            tabbedPane.addTab("Storico", scrollPane);
            return tabbedPane;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new JTabbedPane();
    }

    public boolean GenerateTicket(String dateString, String spettString, String autodromeString) {
        String query = "INSERT INTO biglietti (Data, CodiceSpettatore, CodiceAutodromo) VALUES ( '"+dateString+"', "+spettString+", "+autodromeString+")";
        return this.executeQuery(query);
    }

}

