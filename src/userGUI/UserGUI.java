package src.userGUI;

import src.main.Initial;

import javax.swing.*;

public class UserGUI extends JFrame{
    private JPanel windowPanel;
    private JButton availableBooksButton;
    private JButton issuedBooksButton;
    private JButton logOutButton;
    Initial in = new Initial();


    public UserGUI(int id, String firstname) {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        issuedBooksButton.addActionListener(e -> {
            setVisible(false);
            dispose();
            in.startIssuedBookGUI(id, firstname);
        });

        logOutButton.addActionListener(e -> {
            setVisible(false);
            dispose();
            in.startLoginUI();
        });

        availableBooksButton.addActionListener(e -> {
            setVisible(false);
            dispose();
            in.startAvailableBooksGUI(id, firstname);
        });
    }

    public JPanel getWindowPanel(){
        return windowPanel;
    }

}
