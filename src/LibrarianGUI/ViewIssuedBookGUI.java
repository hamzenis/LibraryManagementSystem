package src.LibrarianGUI;

import src.db.DBCon;
import src.main.Initial;

import javax.swing.*;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewIssuedBookGUI extends JFrame{
    private JPanel windowPanel;
    private JButton backButton;
    private JTable issuedBooksTable;
    private JButton returnButton;
    private JTextField returnTextfield;
    Initial in = new Initial();

    public ViewIssuedBookGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        DBCon dbCon = new DBCon();
        issuedBooksTable.setModel(dbCon.createTableIssuedBooks());

        backButton.addActionListener(e -> {
            setVisible(false);
            dispose();
            in.startLibrarianGUI();
        });

        returnButton.addActionListener(e -> {
            returnBook(Integer.parseInt(returnTextfield.getText()));
            JOptionPane.showMessageDialog(null, "Book returned!");
            returnTextfield.setText("");
            dbCon.createConnection();
            issuedBooksTable.setModel(dbCon.createTableIssuedBooks());
        });
    }

    //  issued book will be deleted from table "Borrow" and will be inserted into table "Returned" for the History
    //  In table "Book" quantity will be increased by 1
    private void returnBook(int borrowID) {
        PreparedStatement stmt1 = null;
        PreparedStatement stmt2 = null;
        PreparedStatement stmt3 = null;
        PreparedStatement stmt4 = null;
        DBCon dbCon = new DBCon();
        ResultSet rs1 = null;
        int rs2, rs3, rs4;
        int book_idBook = 0, user_idUser = 0;
        String dateOfBorrow = "1970-03-31";
        long current = System.currentTimeMillis();
        Date date = new Date(current);
        try {
            //  Get Borrow Date
            String sqlQuery1 = "SELECT * FROM Borrow WHERE idBorrow =  ?;";
            stmt1 = dbCon.getConnection().prepareStatement(sqlQuery1);
            stmt1.setInt(1, borrowID);
            rs1 = stmt1.executeQuery();
            while (rs1.next()) {
                dateOfBorrow = rs1.getString("dateOfBorrow");
                book_idBook = rs1.getInt("Book_idBook");
                user_idUser = rs1.getInt("User_idUser");
            }

            //  Insert into History of Returned Books table
            String sqlQuery2 = "INSERT INTO Returned (dateOfBorrow,Book_idBook,User_idUser,dateOfReturn) VALUES (?,?,?,?);";
            stmt2 = dbCon.getConnection().prepareStatement(sqlQuery2);
            stmt2.setDate(1, Date.valueOf(dateOfBorrow));
            stmt2.setInt(2, book_idBook);
            stmt2.setInt(3, user_idUser);
            stmt2.setDate(4, date);
            rs2 = stmt2.executeUpdate();

            //  Delete from Borrow Table
            String sqlQuery3 = "DELETE FROM Borrow WHERE idBorrow = ?";
            stmt3 = dbCon.getConnection().prepareStatement(sqlQuery3);
            stmt3.setInt(1, borrowID);
            rs3 = stmt3.executeUpdate();

            //  Quantity increase by 1
            String sqlQuery4 = "UPDATE Book SET quantity = quantity + 1 WHERE idBook = ?;";
            stmt4 = dbCon.getConnection().prepareStatement(sqlQuery4);
            stmt4.setInt(1, book_idBook);
            rs4 = stmt4.executeUpdate();

        } catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null, "Wrong Borrow ID!");
        }
    }

    public JPanel getWindowPanel() {
        return windowPanel;
    }
}
