package src.main;


/*      TODO:
 *   - Add more DBCon functions
 *   - Add save button functionality in every GUI window
 *   - setDefaultCloseOperation(EXIT_ON_CLOSE); in jedes GUI einfügen
 *   - Connect LoginGUI with User Table Mysql
 *   - ...
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