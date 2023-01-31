package src.main;


/*      TODO:
 *  - Link Genre JCombobox with Database in AddBookGUI
 *  - Change code in createTable() && searchBookAuthor() with PreparedStatement
 *  - Buttons with enter input
 *  - Return a Book!!!!!!!!! in EntriesGUI with a table to view returned Books
 *  - Add a table history in database!!!!! cc of borrow with returnedDate
 *  - IssuedBooks userGUI Table
 *  - ReturnedBook GUI
 *  - Add in Database History Books table (as borrowedTable)
 *  - EntriesGUI and database logic
 *  - Issue Book GUI anpassen und logic
 *
 *      Backlog (later TODO):
 *          - Add possibility to add more than one author per book
 *          - Update Readme File
 *          - Replace printStackTrace() when in production code -> getMessage()
 *          - $User in User Side GUI replaced with the username
 *          - ...
 *
 */
public class Main {

    public static void main(String[] args) {

        //  Only Debug Terminal Output
        System.out.println("Hello World");

        //  Program start code
        Initial startProject = new Initial();
        startProject.startLoginUI();

    }
}