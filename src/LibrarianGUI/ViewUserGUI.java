package src.LibrarianGUI;

import src.main.Initial;

import javax.swing.*;

public class ViewUserGUI extends JFrame {
    private JPanel windowPanel;
    private JButton backButton;
    Initial in = new Initial();

    public ViewUserGUI() {
        backButton.addActionListener(e -> {
            setVisible(false);
            dispose();
            in.startLibrarianGUI();
        });
    }

    public JPanel getWindowPanel() {
        return windowPanel;
    }
}