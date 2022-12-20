package src.logingui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import src.main.Initial;

public class Login extends JFrame {

    //  GUI Vars
    private JPasswordField passwordTextfield;
    private JTextField usernameTextfield;
    private JButton logInButton;
    private JButton closeButton;
    private JPanel windowPanel;
    private JLabel passwortJLabel;
    private JLabel usernameJLabel;
    Initial in = new Initial();


    public Login()  {

        /* Close program with "X" button
        *  (auch in Initial möglich[siehe startLoginGUI],
        *  jedoch besser wenn alles erbt von Klasse GUI[siehe Idea Improvements])
        *
        */
        // setDefaultCloseOperation(EXIT_ON_CLOSE);





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
                    dispose();
                    in.startLibrarianGUI();
                } else if (usernameTextfield.getText().equals("user") && passwordTextfield.getText().equals("user")) {
                    setVisible(false);
                    dispose();
                    in.startUserGUI();
                } else JOptionPane.showMessageDialog(null, "Incorrect Password");

            }
        });


    }

    /*  Getter */
    public JPanel getLoginWindowPanel(){
        return windowPanel;
    }

}
