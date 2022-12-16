package src.LibrarianGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddBookGUI extends JFrame{
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JButton backButton;
    private JButton saveButton;

    public AddBookGUI() {
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

    public JPanel getPanel1(){

        return panel1;
    }
}
