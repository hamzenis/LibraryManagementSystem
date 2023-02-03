package src.main;


/*      TODO:
 *  - Return a Book!!!!!!!!! in EntriesGUI with a table to view returned Books
 *  - IssuedBooks userGUI Table
 *  - ReturnedBook GUI
 *  - EntriesGUI and database logic
 *  - Issue Book GUI anpassen und logic
 *  - Add Text-flied and Button (Return Button) into IssuedBooks GUI Admin
 *  - Add Return function into IssuedBooks GUI
 *  - Issue Book GUI new Design and Save Button functionality
 *  - SQL Code generate DB with standard user and Genres
 *
 *      Backlog (later TODO):
 *          - Add possibility to add more than one author per book
 *          - Update Readme File
 *          - Replace printStackTrace() when in production code -> getMessage()
 *          - $User in User Side GUI replaced with the username
 *          - Link Genre JCombobox with Database in AddBookGUI
 *          - Buttons with enter input
 *
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