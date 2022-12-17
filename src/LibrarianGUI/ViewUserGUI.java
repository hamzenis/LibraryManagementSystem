package src.LibrarianGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewUserGUI extends JFrame {
    private JPanel ViewUserPanel;
    private JButton backButton;

    public ViewUserGUI() {
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                StartGUILibrarian nl2 = new StartGUILibrarian();
                nl2.setVisible(true);
                nl2.setContentPane(nl2.getLibrarians());
                nl2.setExtendedState(MAXIMIZED_BOTH);
            }
        });
    }

    public JPanel getViewUserPanel() {
        return ViewUserPanel;
    }
}