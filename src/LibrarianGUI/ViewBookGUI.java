package src.LibrarianGUI;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ViewBookGUI extends JFrame {

    private JPanel ViewBookPanel;
    private JButton backButton;

    public ViewBookGUI() {
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                StartGUILibrarian nl1 = new StartGUILibrarian();
                nl1.setVisible(true);
                nl1.setContentPane(nl1.getLibrarians());
                nl1.setExtendedState(MAXIMIZED_BOTH);
            }
        });
    }

    public JPanel getViewBookPanel(){
        return ViewBookPanel;
    }
}
