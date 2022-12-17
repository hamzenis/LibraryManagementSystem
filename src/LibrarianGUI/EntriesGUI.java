package src.LibrarianGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EntriesGUI extends JFrame{
    private JPanel Panel7;
    private JButton backButton;

    public EntriesGUI() {
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                StartGUILibrarian newGuiLibrerian = new StartGUILibrarian();
                newGuiLibrerian.setVisible(true);
                newGuiLibrerian.setContentPane(newGuiLibrerian.getLibrarians());
                newGuiLibrerian.setExtendedState(MAXIMIZED_BOTH);
            }
        });
    }

    public JPanel getPanel7(){
        return  Panel7;
    }
}
