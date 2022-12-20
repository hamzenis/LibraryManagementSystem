package src.LibrarianGUI;

import src.main.Initial;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                dispose();
                in.startLibrarianGUI();
            }
        });
    }

    public JPanel getWindowPanel(){
        return windowPanel;
    }
}
