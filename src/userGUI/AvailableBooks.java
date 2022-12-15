package src.userGUI;

import src.main.Initialize;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AvailableBooks extends JFrame {
    private JPanel panel4;
    private JButton AvailableBooksbackButton;
    Initialize in = new Initialize();


    public AvailableBooks() {
        AvailableBooksbackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                in.startUserGUI();
            }
        });
    }

    public JPanel getPanel4(){
        return panel4;
    }
}
