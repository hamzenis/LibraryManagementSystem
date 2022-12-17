package src.LibrarianGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IssuebookUsersGUI extends JFrame{
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JPanel Panel5;
    private JButton backButton;
    private JButton saveButton;

    public IssuebookUsersGUI() {
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                StartGUILibrarian nl = new StartGUILibrarian();
                nl.setVisible(true);
                nl.setContentPane(nl.getLibrarians());
                nl.setExtendedState(MAXIMIZED_BOTH);
            }
        });
    }

    public JPanel getPanel5(){
        return Panel5;
    }
}
