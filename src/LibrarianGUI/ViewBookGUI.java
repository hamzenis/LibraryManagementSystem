package src.LibrarianGUI;
import src.main.Initial;

import javax.swing.*;


public class ViewBookGUI extends JFrame {

    private JPanel windowPanel;
    private JButton backButton;
    private JTable table1;
    Initial in = new Initial();

    public ViewBookGUI() {
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
