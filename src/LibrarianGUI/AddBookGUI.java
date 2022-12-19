package src.LibrarianGUI;

import src.main.Initial;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddBookGUI extends JFrame{
    private JPanel windowPanel;
    private JTextField inputBookID;
    private JTextField inputBookName;
    private JTextField inputDate;
    private JTextField inputGenre;
    private JTextField inputQuantity;
    private JButton backButton;
    private JButton saveButton;
    Initial in = new Initial();

    public AddBookGUI() {
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                in.startLibrarianGUI();
            }
        });
    }

    public JPanel getWindowPanel(){

        return windowPanel;
    }
}
