package src.main;

import src.LibrarianGUI.*;
import src.logingui.Login;
import src.userGUI.AvailableBooks;
import src.userGUI.IssuedBooks;
import src.userGUI.UserGUI;

import static java.awt.Frame.MAXIMIZED_BOTH;

public class Initial {

    //  Window objects

    StartGUILibrarian li = new StartGUILibrarian();
    IssuedBooks ib = new IssuedBooks();
    AvailableBooks ab = new AvailableBooks();
    UserGUI ug = new UserGUI();
    Login lo = new Login();
    AddUserGUI newAddUser = new AddUserGUI();
    IssuebookUsersGUI newIssueBUser = new IssuebookUsersGUI();
    EntriesGUI newEntries = new EntriesGUI();
    AddBookGUI newBook = new AddBookGUI();
    ViewBookGUI vb = new ViewBookGUI();
    ViewIssuedBookGUI vib = new ViewIssuedBookGUI();
    ViewReturnedBookGUI rb = new ViewReturnedBookGUI();
    ViewUserGUI vu = new ViewUserGUI();





    //  Start of Program
    public void startLoginUI(){
        lo.setContentPane(lo.getLoginWindowPanel());
        lo.setTitle("Welcome to LMS");
        lo.setSize(250,200);
        lo.setVisible(true);
    }

    /*  Side User UI*/

    public void startUserGUI(){
        ug.setContentPane(ug.getWindowPanel());
        ug.setTitle("Welcome $User to LMS - Library Management System");
        ug.setVisible(true);
        ug.setExtendedState(MAXIMIZED_BOTH);
    }

    public void startAvailableBooksGUI(){
        ab.setContentPane(ab.getWindowPanel());
        ug.setTitle("Welcome $User to LMS - Library Management System");
        ab.setVisible(true);
        ab.setExtendedState(MAXIMIZED_BOTH);
    }

    public void startIssuedBookGUI(){
        ib.setContentPane(ib.getWindowPanel());
        ug.setTitle("Welcome $User to LMS - Library Management System");
        ib.setVisible(true);
        ib.setExtendedState(MAXIMIZED_BOTH);
    }


    /* Side Admin UI */

    public void startLibrarianGUI(){
        li.setContentPane(li.getWindowPanel());
        ug.setTitle("LMS-Admin Panel");
        li.setVisible(true);
        li.setExtendedState(MAXIMIZED_BOTH);
    }

    public void startAddBookGUI(){
        newBook.setVisible(true);
        newBook.setContentPane(newBook.getWindowPanel());
        newBook.setExtendedState(MAXIMIZED_BOTH);
    }

    public void startAddUserGUI(){
        newAddUser.setContentPane(newAddUser.getWindowPanel());
        newAddUser.setVisible(true);
        newAddUser.setExtendedState(MAXIMIZED_BOTH);
    }

    public void startIssueBookUsersGUI(){
        newIssueBUser.setContentPane(newIssueBUser.getWindowPanel());
        newIssueBUser.setVisible(true);
        newIssueBUser.setExtendedState(MAXIMIZED_BOTH);
    }

    public void startEntriesGUI(){
        newEntries.setContentPane(newEntries.getWindowPanel());
        newEntries.setVisible(true);
        newEntries.setExtendedState(MAXIMIZED_BOTH);
    }

    public void startViewBookGUI(){
        vb.setVisible(true);
        vb.setContentPane(vb.getWindowPanel());
        vb.setExtendedState(MAXIMIZED_BOTH);
    }

    ///////
    public void startViewIssuedBook(){
        vib.setVisible(true);
        vib.setContentPane(ib.getWindowPanel());
        vib.setExtendedState(MAXIMIZED_BOTH);
    }

    public void startViewReturnedBook(){
        rb.setVisible(true);
        rb.setContentPane(rb.getWindowPanel());
        rb.setExtendedState(MAXIMIZED_BOTH);
    }

    public void startViewUserGUI(){
        vu.setVisible(true);
        vu.setContentPane(vu.getWindowPanel());
        vu.setExtendedState(MAXIMIZED_BOTH);
    }

}
