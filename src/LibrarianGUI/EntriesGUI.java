package src.LibrarianGUI;

import src.main.Initial;

import javax.swing.*;

public class EntriesGUI extends JFrame{
    private JPanel windowPanel;
    private JButton backButton;
    private JTable table1;
    private JButton returnButton;
    private JTextField textField1;
    Initial in = new Initial();

    public EntriesGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
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
