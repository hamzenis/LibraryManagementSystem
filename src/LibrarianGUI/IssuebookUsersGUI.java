package src.LibrarianGUI;

import src.main.Initial;

import javax.swing.*;

public class IssuebookUsersGUI extends JFrame{
    private JTextField inputIssueID;
    private JTextField inputDate;
    private JTextField inputBookID;
    private JTextField inputUserID;
    private JPanel windowPanel;
    private JButton backButton;
    private JButton saveButton;
    Initial in = new Initial();

    public IssuebookUsersGUI() {
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
