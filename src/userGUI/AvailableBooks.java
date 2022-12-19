package src.userGUI;

import src.main.Initial;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AvailableBooks extends JFrame {
    private JPanel windowPanel;
    private JButton backbutton;
    private JButton searchButton;
    private JTextField inputField;
    Initial in = new Initial();


    public AvailableBooks() {
        backbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                in.startUserGUI();
            }
        });
    }

    public JPanel getWindowPanel(){
        return windowPanel;
    }
}
