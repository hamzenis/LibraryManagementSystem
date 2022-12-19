package src.LibrarianGUI;
import src.main.Initial;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ViewBookGUI extends JFrame {

    private JPanel windowPanel;
    private JButton backButton;
    Initial in = new Initial();

    public ViewBookGUI() {
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                in.startLibrarianGUI();
            }
        });
    }

    public JPanel getWindowPanel(){
        return windowPanel;
    }
}
