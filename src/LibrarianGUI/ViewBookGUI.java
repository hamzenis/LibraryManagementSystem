package src.LibrarianGUI;
import src.db.DBCon;
import src.main.Initial;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.Statement;


public class ViewBookGUI extends JFrame {

    private JPanel windowPanel;
    private JButton backButton;
    private JTable bookTable;
    private JButton fetchButton;
    Initial in = new Initial();

    public ViewBookGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        createTable();
        backButton.addActionListener(e -> {
            setVisible(false);
            dispose();
            in.startLibrarianGUI();
        });

        // Can be deleted, no functionality planned, delete in form
        fetchButton.addActionListener(e -> {
            //  Debug
            String newS = getGenre(2);
            System.out.println("Button pressed placeholder");
            System.out.println(newS);
        });
    }

    //  Creates Table Book
    private void createTable() {
        DBCon dbCon = new DBCon();
        String[] columnNames = {"Book Title", "Publishing Year", "Genre", "Quantity"};
        DefaultTableModel modelBookTable = new DefaultTableModel(columnNames, 0);
        try {
            Statement statement = dbCon.getConnection().createStatement();
            String sqlQuery = "Select * From Book";
            ResultSet rs = statement.executeQuery(sqlQuery);
            while (rs.next()) {
                String bookTitle = rs.getString("bookTitle");
                String pubYear = rs.getString("pubYear");
                String genre = getGenre(rs.getInt("Category_idCategory"));
                String quantity = rs.getString("quantity");
                String[] data = {bookTitle, pubYear, genre, quantity};
                modelBookTable.addRow(data);
            }
            bookTable.setModel(modelBookTable);
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //  Function to get the right genre as a String
    private String getGenre(int idGenre) {
        String sqlInput = "Select genre FROM Category WHERE idCategory = " + idGenre + ";";
        DBCon dbCon = new DBCon();
        String genre = null;
        try {
            Statement st = dbCon.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sqlInput);
            while (rs.next()) genre = rs.getString("genre");
            rs.close();
            return genre;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return genre;
    }


    public JPanel getWindowPanel() {
        return windowPanel;
    }


}
