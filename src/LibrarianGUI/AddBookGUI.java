package src.LibrarianGUI;

import src.main.Initial;

import javax.swing.*;

public class AddBookGUI extends JFrame{
    private JPanel windowPanel;
    private JTextField authorLName;
    private JTextField inputBookName;
    private JTextField inputDate;
    private JTextField inputQuantity;
    private JButton backButton;
    private JButton saveButton;
    private JTextField authorFName;
    private JComboBox comboBox1;
    Initial in = new Initial();

    public AddBookGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        backButton.addActionListener(e -> {
            setVisible(false);
            dispose();
            in.startLibrarianGUI();
        });
        saveButton.addActionListener(e -> {
            //  Add Book and Author and book_author
            String inputBookSQL = "insert into " + inputBookName;
            String inputAuthorSQL = "insert into ";


        });

    }

    public JPanel getWindowPanel(){
        return windowPanel;
    }
}
