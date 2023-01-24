package src.LibrarianGUI;
import src.db.DBCon;
import src.main.Initial;

import javax.swing.*;


public class ViewBookGUI extends JFrame {

    private JPanel windowPanel;
    private JButton backButton;
    private JTable bookTable;
    private JButton searchButton;
    private JTextField searchField;
    Initial in = new Initial();

    public ViewBookGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        DBCon dbCon = new DBCon();
        bookTable.setModel(dbCon.createTableBooks());

        backButton.addActionListener(e -> {
            setVisible(false);
            dispose();
            in.startLibrarianGUI();
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
