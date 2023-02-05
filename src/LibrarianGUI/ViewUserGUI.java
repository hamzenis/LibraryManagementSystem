package src.LibrarianGUI;

import src.db.DBCon;
import src.main.Initial;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.Statement;

public class ViewUserGUI extends JFrame {
    private JPanel windowPanel;
    private JButton backButton;
    private JTable userTable;
    Initial in = new Initial();

    public ViewUserGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        createTable();

        backButton.addActionListener(e -> {
            setVisible(false);
            dispose();
            in.startLibrarianGUI();
        });
    }

    //  Creates Table User
    private void createTable() {
        DBCon dbCon = new DBCon();
        String[] columnNames = {"Username", "Firstname", "Lastname", "Is Librarian"};
        DefaultTableModel modelUserTable = new DefaultTableModel(columnNames, 0);
        try {
            Statement statement = dbCon.getConnection().createStatement();
            String sqlQuery = "Select * From User";
            ResultSet rs = statement.executeQuery(sqlQuery);
            while (rs.next()) {
                String username = rs.getString("idUser");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String isLibrarian = (rs.getInt("isLibrarian") == 1) ? "Yes" : "No";
                String[] data = {username, firstname, lastname, isLibrarian};
                modelUserTable.addRow(data);
            }
            userTable.setModel(modelUserTable);
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public JPanel getWindowPanel() {
        return windowPanel;
    }
}