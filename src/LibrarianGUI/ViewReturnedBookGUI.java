package src.LibrarianGUI;

import src.main.Initial;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewReturnedBookGUI extends JFrame {

    private JPanel windowPanel;
    private JButton backButton;
    Initial in = new Initial();

    public ViewReturnedBookGUI() {
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                dispose();
                in.startLibrarianGUI();
            }
        });
    }

    public JPanel getWindowPanel(){
        return windowPanel;
    }
}
