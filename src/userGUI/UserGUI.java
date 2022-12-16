package src.userGUI;

import src.logingui.Login;
import src.main.Initialize;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserGUI extends JFrame{
    private JPanel panel1;
    private JButton availableBooksButton;
    private JButton issuedBooksButton;
    private JButton logOutButton;
    Initialize in = new Initialize();


    public UserGUI() {
        issuedBooksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                in.startIssuedBookGUI();
            }
        });
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                in.startLoginUI();
            }
        });
        availableBooksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                in.startAvailableBooksGUI();
            }
        });
    }

    public JPanel getPanel1 (){
        return panel1;
    }

}
