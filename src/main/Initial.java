package src.main;

import src.LibrarianGUI.*;
import src.logingui.*;
import src.userGUI.*;

public class Initial {

    /*  Code Comments:
    *   - setSize(x,y) for perfered size, but pack() for minimum size
    *      - pack() ausprobiert in then GUIs: userGUI, librarianGUI, addBookGUI [setExtendedState() auskommentieren]
    *
    *   - setLocationRelativeTo(null) sets Location of Window to the center of the screen
    *
    */

    /*  Start of Program */
    public void startLoginUI(){
        Login lo = new Login();
        lo.setContentPane(lo.getLoginWindowPanel());
        lo.setTitle("Welcome to LMS");
        lo.setSize(350, 300);
        lo.setLocationRelativeTo(null);
        lo.setVisible(true);
    }

    /*  Side User UI */

    public void startUserGUI(int id) {
        UserGUI ug = new UserGUI(id);
        ug.setContentPane(ug.getWindowPanel());
        ug.setTitle("Welcome $User to LMS - Library Management System");
        //ug.setExtendedState(MAXIMIZED_BOTH);
        ug.setSize(550, 700);
        ug.setLocationRelativeTo(null);
        ug.setVisible(true);
        //ug.pack();
        //ug.setLocationRelativeTo(null);
    }

    public void startAvailableBooksGUI(int id) {
        AvailableBooks ab = new AvailableBooks(id);
        ab.setContentPane(ab.getWindowPanel());
        ab.setTitle("Welcome $User to LMS - Library Management System");
        //ab.setExtendedState(MAXIMIZED_BOTH);
        ab.setSize(700, 700);
        ab.setLocationRelativeTo(null);
        ab.setVisible(true);
        //ab.pack();
        //ab.setLocationRelativeTo(null);
    }

    public void startIssuedBookGUI(int id) {
        System.out.println("Initial->startIssuedBooks(): " + id);
        IssuedBooks ib = new IssuedBooks(id);
        ib.setContentPane(ib.getWindowPanel());
        ib.setTitle("Welcome $User to LMS - Library Management System");
        //ib.setExtendedState(MAXIMIZED_BOTH);
        ib.setSize(700, 700);
        ib.setLocationRelativeTo(null);
        ib.setVisible(true);
        //ib.pack();
        //ib.setLocationRelativeTo(null);
    }


    /* Side Admin UI */

    public void startLibrarianGUI(){
        StartGUILibrarian li = new StartGUILibrarian();
        li.setContentPane(li.getWindowPanel());
        li.setTitle("LMS-Admin Panel");
        //li.setExtendedState(MAXIMIZED_BOTH);
        li.setSize(550,700);
        li.setLocationRelativeTo(null);
        li.setVisible(true);
        //li.pack();
        //li.setLocationRelativeTo(null);
    }

    public void startAddBookGUI(){
        AddBookGUI ab = new AddBookGUI();
        ab.setTitle("LMS-Admin Panel");
        ab.setContentPane(ab.getWindowPanel());
        //ab.setExtendedState(MAXIMIZED_BOTH);
        ab.setSize(700,700);
        ab.setLocationRelativeTo(null);
        ab.setVisible(true);
        //ab.pack();
        //ab.setLocationRelativeTo(null);
    }

    public void startAddUserGUI(){
        AddUserGUI au = new AddUserGUI();
        au.setTitle("LMS-Admin Panel");
        au.setContentPane(au.getWindowPanel());
        //au.setExtendedState(MAXIMIZED_BOTH);
        au.setSize(700,700);
        au.setLocationRelativeTo(null);
        au.setVisible(true);
        //au.pack();
        //au.setLocationRelativeTo(null);
    }

    public void startIssueBookUsersGUI(){
        IssuebookUsersGUI ibu = new IssuebookUsersGUI();
        ibu.setTitle("LMS-Admin Panel");
        ibu.setContentPane(ibu.getWindowPanel());
        //ibu.setExtendedState(MAXIMIZED_BOTH);
        ibu.setSize(700,700);
        ibu.setLocationRelativeTo(null);
        ibu.setVisible(true);
        //ibu.pack();
        //ibu.setLocationRelativeTo(null);
    }

    public void startEntriesGUI(){
        EntriesGUI ne = new EntriesGUI();
        ne.setTitle("LMS-Admin Panel");
        ne.setContentPane(ne.getWindowPanel());
        //ne.setExtendedState(MAXIMIZED_BOTH);
        ne.setSize(700,700);
        ne.setLocationRelativeTo(null);
        ne.setVisible(true);
        ne.setSize(700,700);
        ne.setLocationRelativeTo(null);
        ne.setVisible(true);
        //ne.pack();
        //ne.setLocationRelativeTo(null);
    }

    public void startViewBookGUI(){
        ViewBookGUI vb = new ViewBookGUI();
        vb.setTitle("LMS-Admin Panel");
        vb.setContentPane(vb.getWindowPanel());
        //vb.setExtendedState(MAXIMIZED_BOTH);
        vb.setSize(700,700);
        vb.setLocationRelativeTo(null);
        vb.setVisible(true);
        //vb.pack();
        //vb.setLocationRelativeTo(null);
    }

    public void startViewIssuedBook(){
        ViewIssuedBookGUI vib = new ViewIssuedBookGUI();
        vib.setContentPane(vib.getWindowPanel());
        vib.setTitle("LMS-Admin Panel");
        //vib.setExtendedState(MAXIMIZED_BOTH);
        vib.setSize(700,700);
        vib.setLocationRelativeTo(null);
        vib.setVisible(true);
        //vib.pack();
        //vib.setLocationRelativeTo(null);
    }

    public void startViewReturnedBook(){
        ViewReturnedBookGUI rb = new ViewReturnedBookGUI();
        rb.setContentPane(rb.getWindowPanel());
        rb.setTitle("LMS-Admin Panel");
        //rb.setExtendedState(MAXIMIZED_BOTH);
        rb.setSize(700,700);
        rb.setLocationRelativeTo(null);
        rb.setVisible(true);
        //rb.pack();
        //rb.setLocationRelativeTo(null);
    }

    public void startViewUserGUI(){
        ViewUserGUI vu = new ViewUserGUI();
        vu.setContentPane(vu.getWindowPanel());
        vu.setTitle("LMS-Admin Panel");
        //vu.setExtendedState(MAXIMIZED_BOTH);
        vu.setSize(700,700);
        vu.setLocationRelativeTo(null);
        vu.setVisible(true);
        //vu.pack();
        //vu.setLocationRelativeTo(null);
    }


}
