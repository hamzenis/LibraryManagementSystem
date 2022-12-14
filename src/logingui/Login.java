package src.logingui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                if(usernameTextfield.getText().equals("admin") && passwordTextfield.getText().equals("admin"))
                {
                    setVisible(false);
                }
            }
        });


    }

    /*  Getter */
    public JPanel getLoginWindowPanel(){
        return windowPanel;
    }

}
