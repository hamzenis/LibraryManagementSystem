package src.LibrarianGUI;

import src.main.Initial;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewUserGUI extends JFrame {
    private JPanel windowPanel;
    private JButton backButton;
    Initial in = new Initial();

    public ViewUserGUI() {
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                in.startLibrarianGUI();
            }
        });
    }

    public JPanel getWindowPanel() {
        return windowPanel;
    }
}