package src.userGUI;

import src.main.Initial;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IssuedBooks extends JFrame{
    private JPanel windowPanel;
    private JButton backButton;
    Initial in = new Initial();


    public IssuedBooks() {
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                dispose();
                in.startUserGUI();
            }
        });
    }

    public JPanel getWindowPanel(){
        return windowPanel;
    }


}
