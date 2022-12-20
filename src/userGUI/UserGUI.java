package src.userGUI;

import src.main.Initial;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserGUI extends JFrame{
    private JPanel windowPanel;
    private JButton availableBooksButton;
    private JButton issuedBooksButton;
    private JButton logOutButton;
    Initial in = new Initial();


    public UserGUI() {
        issuedBooksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                dispose();
                in.startIssuedBookGUI();
            }
        });
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                dispose();
                in.startLoginUI();
            }
        });
        availableBooksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                dispose();
                in.startAvailableBooksGUI();
            }
        });
    }

    public JPanel getWindowPanel(){
        return windowPanel;
    }

}
