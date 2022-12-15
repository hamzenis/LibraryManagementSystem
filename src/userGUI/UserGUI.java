package src.userGUI;

import src.logingui.Login;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserGUI extends JFrame{
    private JPanel panel1;
    private JButton availableBooksButton;
    private JButton issuedBooksButton;
    private JButton logOutButton;

    public UserGUI() {
        issuedBooksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                IssuedBooks ib = new IssuedBooks();
                ib.setContentPane(ib.getPanel3());
                ib.setVisible(true);
                ib.setExtendedState(MAXIMIZED_BOTH);
            }
        });
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Login newLogin = new Login();
                newLogin.setContentPane(newLogin.getLoginWindowPanel());
                newLogin.setVisible(true);
                newLogin.setSize(250,200);
            }
        });
        availableBooksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                AvailableBooks ab = new AvailableBooks();
                ab.setContentPane(ab.getPanel4());
                ab.setVisible(true);
                ab.setExtendedState(MAXIMIZED_BOTH);
            }
        });
    }

    public JPanel getPanel1 (){
        return panel1;
    }

}
