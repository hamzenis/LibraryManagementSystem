package src.LibrarianGUI;

import src.main.Initial;

import javax.swing.*;

public class AddUserGUI extends JFrame{
    private JTextField inputUserID;
    private JTextField inputUsername;
    private JTextField inputLastname;
    private JComboBox inputTypeUser;
    private JPanel windowPanel;
    private JButton backButton;
    private JButton saveButton;
    Initial in = new Initial();

    public AddUserGUI() {
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
