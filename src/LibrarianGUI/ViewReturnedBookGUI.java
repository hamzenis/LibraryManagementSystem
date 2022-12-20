package src.LibrarianGUI;

import src.main.Initial;

import javax.swing.*;

public class ViewReturnedBookGUI extends JFrame {

    private JPanel windowPanel;
    private JButton backButton;
    Initial in = new Initial();

    public ViewReturnedBookGUI() {
        backButton.addActionListener(e -> {
            setVisible(false);
            dispose();
            in.startLibrarianGUI();
        });
    }

    public JPanel getWindowPanel(){
        return windowPanel;
    }
}
