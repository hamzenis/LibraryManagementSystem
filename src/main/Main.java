package src.main;


/*      TODO:
 *   - Add more DBCon functions
 *   - Add save button functionality in every GUI window
 *   - Connect LoginGUI with User Table Mysql
 *   - Update Readme File
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