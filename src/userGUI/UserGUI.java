package src.userGUI;

import src.main.Initial;

import javax.swing.*;

public class UserGUI extends JFrame{
    private JPanel windowPanel;
    private JButton availableBooksButton;
    private JButton issuedBooksButton;
    private JButton logOutButton;
    Initial in = new Initial();


    public UserGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        issuedBooksButton.addActionListener(e -> {
            setVisible(false);
            dispose();
            in.startIssuedBookGUI();
        });

        logOutButton.addActionListener(e -> {
            setVisible(false);
            dispose();
            in.startLoginUI();
        });

        availableBooksButton.addActionListener(e -> {
            setVisible(false);
            dispose();
            in.startAvailableBooksGUI();
        });
    }

    public JPanel getWindowPanel(){
        return windowPanel;
    }

}
