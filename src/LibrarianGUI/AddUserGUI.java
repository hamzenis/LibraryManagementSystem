package src.LibrarianGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddUserGUI extends JFrame{
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JComboBox comboBox1;
    private JPanel AddUserPanel;
    private JButton backButton;
    private JButton saveButton;

    public AddUserGUI() {
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                StartGUILibrarian sg = new StartGUILibrarian();
                sg.setVisible(true);
                sg.setContentPane(sg.getLibrarians());
                sg.setExtendedState(MAXIMIZED_BOTH);
            }
        });
    }

    public JPanel getAddUserPanel() {
        return AddUserPanel;
    }
}
