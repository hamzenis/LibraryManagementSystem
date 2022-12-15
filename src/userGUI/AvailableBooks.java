package src.userGUI;

import src.main.Initialize;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AvailableBooks extends JFrame {
    private JPanel panel4;
    private JButton AvailableBooksbackButton;

    public AvailableBooks() {
        AvailableBooksbackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Initialize in = new Initialize();
                in.startUserGUI();
            }
        });
    }

    public JPanel getPanel4(){
        return panel4;
    }
}
