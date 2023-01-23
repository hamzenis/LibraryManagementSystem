package src.userGUI;

import src.db.DBCon;
import src.main.Initial;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.Statement;

public class AvailableBooks extends JFrame {
    private JPanel windowPanel;
    private JButton backButton;
    private JButton searchButton;
    private JTextField inputField;
    private JTable bookTable;
    Initial in = new Initial();


    public AvailableBooks() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        createTable();

        backButton.addActionListener(e -> {
            setVisible(false);
            dispose();
            in.startUserGUI();
        });
    }

    //  Creates Table Book with Authors name
    private void createTable() {
        DBCon dbCon = new DBCon();
        String[] columnNames = {"Book Title", "Publishing Year", "Genre", "Quantity", "Author"};
        DefaultTableModel modelBookTable = new DefaultTableModel(columnNames, 0);
        try {
            Statement statement = dbCon.getConnection().createStatement();
            String sqlQuery = "Select Book.*, Author.firstname, Author.lastname from Book "
                    + "JOIN book_author ON Book.idBook = book_author.Book_idBook "
                    + "JOIN Author ON book_author.Author_idAuthor = Author.idAuthor";
            ResultSet rsBook = statement.executeQuery(sqlQuery);
            while (rsBook.next()) {
                String bookTitle = rsBook.getString("bookTitle");
                String pubYear = rsBook.getString("pubYear");
                String genre = getGenre(rsBook.getInt("Category_idCategory"));
                String quantity = rsBook.getString("quantity");
                String author = rsBook.getString("firstname") + " " + rsBook.getString("lastname");
                String[] data = {bookTitle, pubYear, genre, quantity, author};
                modelBookTable.addRow(data);
            }
            bookTable.setModel(modelBookTable);
            rsBook.close();
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
