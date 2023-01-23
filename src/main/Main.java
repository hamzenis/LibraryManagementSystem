package src.main;


/*      TODO:
 *   - Add save button functionality in every GUI window
 *   - Connect LoginGUI with User Table Mysql
 *   - Add search field from AvailableBooksGUI in userGUI-package to ViewBook GUI in librarianGUI-package
 *   - Link Genre JCombobox with Database in AddBookGUI
 *   - Add functionality in Search field in ViewBookGUI and AvailableBookGUI
 *   - Clean up createTable() in ViewBookGUI and AvailableBookGUI
 *
 *      Backlog (later TODO):
 *          - Add possibility to add more than one author per book
 *          - Update Readme File
 *          - Replace printStackTrace() when in production code -> getMessage()
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