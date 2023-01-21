package src.main;


/*      TODO:
 *   - Add save button functionality in every GUI window
 *   - Connect LoginGUI with User Table Mysql
 *   - Update Readme File
 *   - Add search field from AvailableBooksGUI in userGUI-package to ViewBook GUI in librarianGUI-package
 *   - Add in View Book GUI: Author firstname and lastname
 *   - Add possibility to add more than one author per book
 *   - Rewrite code from saveButton in function insertUser() from AddUserGui and add it into DBCon Class
 *   - ....
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