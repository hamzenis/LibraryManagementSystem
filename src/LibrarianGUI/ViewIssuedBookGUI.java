package src.LibrarianGUI;

import src.db.DBCon;
import src.main.Initial;

import javax.swing.*;

public class ViewIssuedBookGUI extends JFrame{
    private JPanel windowPanel;
    private JButton backButton;
    private JTable issuedBooksTable;
    Initial in = new Initial();

    public ViewIssuedBookGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        DBCon dbCon = new DBCon();
        issuedBooksTable.setModel(dbCon.createTableIssuedBooks());

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
