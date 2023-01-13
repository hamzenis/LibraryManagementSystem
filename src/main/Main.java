package src.main;


/*      TODO:
 *   - Delete ID in every GUI Form, because of autoincrement in database
 *   - Add more DBCon functions
 *   - Add save button functionality in every GUI window
 *   - setDefaultCloseOperation(EXIT_ON_CLOSE); in jedes GUI einfügen
 *   - Database in Table Author noch Type of User hinzufügen (Administrator/User)
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