package src.LibrarianGUI;

import src.db.DBCon;
import src.main.Initial;

import javax.swing.*;

public class ViewReturnedBookGUI extends JFrame {

    private JPanel windowPanel;
    private JButton backButton;
    private JTable returnedBookTable;
    Initial in = new Initial();

    public ViewReturnedBookGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        DBCon dbCon = new DBCon();
        returnedBookTable.setModel(dbCon.createTableReturnedBooks());

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
