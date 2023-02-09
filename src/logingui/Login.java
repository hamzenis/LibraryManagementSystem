package src.logingui;

import javax.swing.*;

import src.db.DBCon;
import src.main.Initial;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Login extends JFrame {

    //  GUI Vars
    private JPasswordField passwordTextfield;
    private JTextField usernameTextfield;
    private JButton logInButton;
    private JButton closeButton;
    private JPanel windowPanel;
    Initial in = new Initial();


    public Login()  {

        //  Close program with "X" button
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //  Close Button Login
        closeButton.addActionListener(e -> System.exit(0));

        //  Login Button Login
        logInButton.addActionListener(e -> loginAction());

    }

    private void loginAction() {
        try {
            DBCon dbCon = new DBCon();
            int mode = dbCon.getUserMode(Integer.parseInt(usernameTextfield.getText()), passwordTextfield.getText());
            if (mode == 1) {
                setVisible(false);
                dispose();
                in.startLibrarianGUI();
            } else if (mode == 0) {
                setVisible(false);
                dispose();
                int id = Integer.parseInt(usernameTextfield.getText());
                in.startUserGUI(id, getFirstname(id));

            } else JOptionPane.showMessageDialog(null, "Incorrect Password or Username!");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Username is only in numbers!");
        }
    }

    /*  Getter */
    public JPanel getLoginWindowPanel() {
        return windowPanel;
    }

    private String getFirstname(int id) {
        PreparedStatement stmt = null;
        String firstname = null;
        ResultSet rs = null;
        DBCon dbCon = new DBCon();
        try {
            String sqlQuery = "SELECT firstname FROM User WHERE idUser = ?";
            stmt = dbCon.getConnection().prepareStatement(sqlQuery);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) firstname = rs.getString("firstname");
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return firstname;
    }

}
