package src.LibrarianGUI;

import src.main.Initial;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddBookGUI extends JFrame{
    private JPanel windowPanel;
    private JTextField authorLName;
    private JTextField inputBookName;
    private JTextField inputDate;
    private JTextField inputGenre;
    private JTextField inputQuantity;
    private JButton backButton;
    private JButton saveButton;
    private JTextField authorFName;
    Initial in = new Initial();

    public AddBookGUI() {
        backButton.addActionListener(e -> {
            setVisible(false);
            dispose();
            in.startLibrarianGUI();
        });
        saveButton.addActionListener(e -> {
            /*
                String inputSQL = "insert into Author (First_name, Last_name) VALUES ('"
                    + authorFName.getText() + "', '"
                    + authorLName.getText() + "');";

             */

            String inputBookSQL = "insert into";


        });

    }

    public JPanel getWindowPanel(){
        return windowPanel;
    }
}
