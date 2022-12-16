package src.logingui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import src.LibrarianGUI.*;

import src.main.Initialize;
import src.userGUI.*;

public class Login extends JFrame {

    //  GUI Vars
    private JPasswordField passwordTextfield;
    private JTextField usernameTextfield;
    private JButton logInButton;
    private JButton closeButton;
    private JPanel windowPanel;
    private JLabel passwortJLabel;
    private JLabel usernameJLabel;
    private JPanel innererJPanel;
    Initialize in = new Initialize();


    public Login()  {

        /* Login GUI Actions */

        //  Close Button Login
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        //  Login Button Login
        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (usernameTextfield.getText().equals("admin") && passwordTextfield.getText().equals("admin"))
                {
                    setVisible(false);
                    StartGUILibrarian newLiberian = new StartGUILibrarian();
                    newLiberian.setContentPane(newLiberian.getLibrarians());
                    newLiberian.setVisible(true);
                    newLiberian.setExtendedState(MAXIMIZED_BOTH);
                } else if (usernameTextfield.getText().equals("user") && passwordTextfield.getText().equals("user")) {
                    setVisible(false);
                    in.startUserGUI();
                } else JOptionPane.showMessageDialog(null, "Incorrect paswword");

            }
        });


    }

    /*  Getter */
    public JPanel getLoginWindowPanel(){
        return windowPanel;
    }

}
