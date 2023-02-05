package src.main;


/*      TODO:
 *  ------ Implementing ------
 *  ------ Testing -----
 *  - SQL Code generate DB with standard user and Genres
 *  - ReturnedBooks GUI table testing
 *  -
 *
 *      Backlog (later TODO):
 *          - RAM efficient programming
 *          - Add possibility to add more than one author per book
 *          - Update Readme File
 *          - Replace printStackTrace() when in production code -> getMessage()
 *          - $User in User Side GUI replaced with the username
 *          - Link Genre JCombobox with Database in AddBookGUI
 *          - Buttons with enter input
 *          - ISBN for book
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