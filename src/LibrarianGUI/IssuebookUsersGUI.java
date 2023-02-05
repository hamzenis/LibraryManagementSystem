package src.LibrarianGUI;

import src.db.DBCon;
import src.main.Initial;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class IssuebookUsersGUI extends JFrame {
    private JTextField inputUsername;
    private JTextField inputBookID;
    private JTextField inputIssueDate;
    private JPanel windowPanel;
    private JButton backButton;
    private JButton saveButton;
    Initial in = new Initial();

    public IssuebookUsersGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        backButton.addActionListener(e -> {
            setVisible(false);
            dispose();
            in.startLibrarianGUI();
        });


        saveButton.addActionListener(e -> {
            int bookID = Integer.parseInt(inputBookID.getText());
            if (checkQuantity(bookID) > 0) {
                issueBook();
                decreaseQuantity(bookID);
            } else
                JOptionPane.showMessageDialog(null, "No Book left anymore!");
        });
    }

    //  Returns quantity of the book
    private int checkQuantity(int idBook) {
        DBCon dbCon = new DBCon();
        ResultSet rs = null;
        try {
            rs = dbCon.executeQuery("SELECT Quantity FROM Book WHERE idBook = " + idBook + ";");
            if (rs.next()) return Integer.parseInt(rs.getString("quantity"));
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return -1;
    }

    //  Decreases the value of quantity in the book table
    private void decreaseQuantity(int bookID) {
        PreparedStatement stmt = null;
        DBCon dbCon = new DBCon();
        int rs;
        try {
            String sqlQuery = "UPDATE Book SET quantity = quantity - 1 WHERE idBook = ?;";
            stmt = dbCon.getConnection().prepareStatement(sqlQuery);
            stmt.setInt(1, bookID);
            rs = stmt.executeUpdate();
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void issueBook() {
        Statement statement = null;
        try {
            int userID = Integer.parseInt(inputUsername.getText());
            int bookID = Integer.parseInt(inputBookID.getText());
            String issueDate = inputIssueDate.getText();
            String sqlQuery = "INSERT INTO Borrow (dateOfBorrow, Book_idBook, User_idUser) VALUES ('"
                    + issueDate + "',"
                    + bookID + ","
                    + userID + ");";
            DBCon dbCon = new DBCon();
            statement = dbCon.getConnection().createStatement();
            boolean resultSet = statement.execute(sqlQuery);
            JOptionPane.showMessageDialog(null, "Successfully issued!");
            clearInput();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Please enter a valid Username or Book ID!");
        } catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null, "Username or Book ID don't exist!");
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                }
            }
        }
    }

    private void clearInput() {
        inputUsername.setText("");
        inputBookID.setText("");
        inputIssueDate.setText("");
    }

    public JPanel getWindowPanel() {
        return windowPanel;
    }
}
