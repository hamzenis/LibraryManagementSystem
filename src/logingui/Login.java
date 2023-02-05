package src.logingui;

import javax.swing.*;

import src.db.DBCon;
import src.main.Initial;



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
        logInButton.addActionListener(e -> {
            loginAction();
        });

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
                System.out.println("Login: " + Integer.parseInt(usernameTextfield.getText()));
                in.startUserGUI(Integer.parseInt(usernameTextfield.getText()));
            } else JOptionPane.showMessageDialog(null, "Incorrect Password or Username!");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Username is only in numbers!");
        }
    }

    /*  Getter */
    public JPanel getLoginWindowPanel() {
        return windowPanel;
    }

}
