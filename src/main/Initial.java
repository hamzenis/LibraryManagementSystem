package src.main;

import src.LibrarianGUI.*;
import src.logingui.Login;
import src.userGUI.AvailableBooks;
import src.userGUI.IssuedBooks;
import src.userGUI.UserGUI;

import java.awt.*;

import static java.awt.Frame.MAXIMIZED_BOTH;

public class Initial {


    //  Functions
    public static void centreWindow(Window frame) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
    }

    //  Start of Program
    public void startLoginUI(){
        Login lo = new Login();
        lo.setContentPane(lo.getLoginWindowPanel());
        //centreWindow();
        lo.setTitle("Welcome to LMS");
        lo.setSize(250,200);
        lo.setLocationRelativeTo(null);
        lo.setVisible(true);
    }

    /*  Side User UI*/

    public void startUserGUI(){
        UserGUI ug = new UserGUI();
        ug.setContentPane(ug.getWindowPanel());
        ug.setTitle("Welcome $User to LMS - Library Management System");
        ug.setVisible(true);
        ug.setExtendedState(MAXIMIZED_BOTH);
    }

    public void startAvailableBooksGUI(){
        AvailableBooks ab = new AvailableBooks();
        ab.setContentPane(ab.getWindowPanel());
        ab.setTitle("Welcome $User to LMS - Library Management System");
        ab.setVisible(true);
        ab.setExtendedState(MAXIMIZED_BOTH);
    }

    public void startIssuedBookGUI(){
        IssuedBooks ib = new IssuedBooks();
        ib.setContentPane(ib.getWindowPanel());
        ib.setTitle("Welcome $User to LMS - Library Management System");
        ib.setVisible(true);
        ib.setExtendedState(MAXIMIZED_BOTH);
    }


    /* Side Admin UI */

    public void startLibrarianGUI(){
        StartGUILibrarian li = new StartGUILibrarian();
        li.setContentPane(li.getWindowPanel());
        li.setTitle("LMS-Admin Panel");
        li.setVisible(true);
        li.setExtendedState(MAXIMIZED_BOTH);
    }

    public void startAddBookGUI(){
        AddBookGUI ab = new AddBookGUI();
        ab.setTitle("LMS-Admin Panel");
        ab.setVisible(true);
        ab.setContentPane(ab.getWindowPanel());
        ab.setExtendedState(MAXIMIZED_BOTH);
    }

    public void startAddUserGUI(){
        AddUserGUI au = new AddUserGUI();
        au.setTitle("LMS-Admin Panel");
        au.setContentPane(au.getWindowPanel());
        au.setVisible(true);
        au.setExtendedState(MAXIMIZED_BOTH);
    }

    public void startIssueBookUsersGUI(){
        IssuebookUsersGUI ibu = new IssuebookUsersGUI();
        ibu.setTitle("LMS-Admin Panel");
        ibu.setContentPane(ibu.getWindowPanel());
        ibu.setVisible(true);
        ibu.setExtendedState(MAXIMIZED_BOTH);
    }

    public void startEntriesGUI(){
        EntriesGUI ne = new EntriesGUI();
        ne.setTitle("LMS-Admin Panel");
        ne.setContentPane(ne.getWindowPanel());
        ne.setVisible(true);
        ne.setExtendedState(MAXIMIZED_BOTH);
    }

    public void startViewBookGUI(){
        ViewBookGUI vb = new ViewBookGUI();
        vb.setTitle("LMS-Admin Panel");
        vb.setVisible(true);
        vb.setContentPane(vb.getWindowPanel());
        vb.setExtendedState(MAXIMIZED_BOTH);
    }

    public void startViewIssuedBook(){
        ViewIssuedBookGUI vib = new ViewIssuedBookGUI();
        vib.setContentPane(vib.getWindowPanel());
        vib.setTitle("LMS-Admin Panel");
        vib.setVisible(true);
        vib.setExtendedState(MAXIMIZED_BOTH);
    }

    public void startViewReturnedBook(){
        ViewReturnedBookGUI rb = new ViewReturnedBookGUI();
        rb.setContentPane(rb.getWindowPanel());
        rb.setTitle("LMS-Admin Panel");
        rb.setVisible(true);
        rb.setExtendedState(MAXIMIZED_BOTH);
    }

    public void startViewUserGUI(){
        ViewUserGUI vu = new ViewUserGUI();
        vu.setContentPane(vu.getWindowPanel());
        vu.setTitle("LMS-Admin Panel");
        vu.setVisible(true);
        vu.setExtendedState(MAXIMIZED_BOTH);
    }

}
