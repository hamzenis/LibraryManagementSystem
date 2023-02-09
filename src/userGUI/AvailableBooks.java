package src.userGUI;

import src.db.DBCon;
import src.main.Initial;

import javax.swing.*;

public class AvailableBooks extends JFrame {
    private JPanel windowPanel;
    private JButton backButton;
    private JButton searchButton;
    private JTextField searchField;
    private JTable bookTable;
    Initial in = new Initial();



    public AvailableBooks(int idUser, String firstname) {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        DBCon dbCon = new DBCon();
        bookTable.setModel(dbCon.createTableBooks());

        backButton.addActionListener(e -> {
            setVisible(false);
            dispose();
            in.startUserGUI(idUser, firstname);
        });

        searchButton.addActionListener(e -> {
            String searchTerm = searchField.getText();
            dbCon.createConnection();
            bookTable.setModel(dbCon.searchBookAuthor(searchTerm));
        });


    }

    public JPanel getWindowPanel() {
        return windowPanel;
    }

}
