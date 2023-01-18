package src.userGUI;

import src.main.Initial;

import javax.swing.*;

public class IssuedBooks extends JFrame{
    private JPanel windowPanel;
    private JButton backButton;
    Initial in = new Initial();


    public IssuedBooks() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        backButton.addActionListener(e -> {
            setVisible(false);
            dispose();
            in.startUserGUI();
        });
    }

    public JPanel getWindowPanel(){
        return windowPanel;
    }


}
