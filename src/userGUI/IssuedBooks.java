package src.userGUI;

import src.db.DBCon;
import src.main.Initial;

import javax.swing.*;

public class IssuedBooks extends JFrame {
    private JPanel windowPanel;
    private JButton backButton;
    private JTable issuedBooksTable;
    Initial in = new Initial();


    public IssuedBooks(int idUser) {
        System.out.println("IssuedBook: " + idUser);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        DBCon dbCon = new DBCon();
        issuedBooksTable.setModel(dbCon.createTableIssuedBooksUser(idUser));

        backButton.addActionListener(e -> {
            setVisible(false);
            dispose();
            in.startUserGUI(idUser);
        });
    }

    public JPanel getWindowPanel(){
        return windowPanel;
    }


}
