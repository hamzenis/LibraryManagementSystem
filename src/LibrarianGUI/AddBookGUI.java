package src.LibrarianGUI;

import src.db.DBCon;
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
    private JComboBox comboGenre;
    Initial in = new Initial();

    public AddBookGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        backButton.addActionListener(e -> {
            setVisible(false);
            dispose();
            in.startLibrarianGUI();
        });

        saveButton.addActionListener(e -> {
            DBCon dbCon = new DBCon();
            String values[] = {
                    authorFName.getText(),
                    authorLName.getText(),
                    inputBookName.getText(),
                    inputDate.getText(),
                    comboGenre.getSelectedItem().toString(),
                    inputQuantity.getText()
            };
            dbCon.insertBook(values);
            clearInput();
        });

    }

    //  Clear last input
    private void clearInput() {
        authorFName.setText("");
        authorLName.setText("");
        inputBookName.setText("");
        inputDate.setText("");
        comboGenre.setSelectedItem("");
        inputDate.setText("");
        inputQuantity.setText("");
    }


    public JPanel getWindowPanel() {
        return windowPanel;
    }
}
