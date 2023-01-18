package src.userGUI;

import src.main.Initial;

import javax.swing.*;

public class AvailableBooks extends JFrame {
    private JPanel windowPanel;
    private JButton backbutton;
    private JButton searchButton;
    private JTextField inputField;
    Initial in = new Initial();


    public AvailableBooks() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        backbutton.addActionListener(e -> {
            setVisible(false);
            dispose();
            in.startUserGUI();
        });
    }

    public JPanel getWindowPanel(){
        return windowPanel;
    }
}
