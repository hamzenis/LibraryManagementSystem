package src.userGUI;

import src.main.Initialize;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IssuedBooks extends JFrame{
    private JPanel panel3;
    private JButton backButton;

    public IssuedBooks() {
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Initialize in = new Initialize();
                in.startUserGUI();
            }
        });
    }

    public JPanel getPanel3(){
        return panel3;
    }
}
