package src.LibrarianGUI;

import src.main.Initial;

import javax.swing.*;

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
