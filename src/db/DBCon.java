package src.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


/*  How to use:
 *   Create a DBCon Object and use the sqlExecute Function
 *
 */
public class DBCon {

    //  Vars
    Connection connection = null;

    //  Constructor
    public DBCon() {
        createConnection();
    }


    //  Don't have to be executed, because it's executed in the constructor
    public void createConnection() {

        try {
            //  Insert username(normally root) and password(set at MySQL installation) in Connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Library_Management_System", "root", "root");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //  Give a SQL Query to the function and it will be executed.
    public void sqlExecute(String inputSQL) {

        try {
            Statement statement = connection.createStatement();
            boolean resultSet = statement.execute(inputSQL);

            /*  Debug:
             *  boolean resultSet = statement.execute("insert into Author (First_name, Last_name) VALUES ('Hamzenis', 'Kryeziu');");
             */

            //  Debug
            System.out.println("Done!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void printTableAuthor() {
    /*  Debug print statement
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from Author");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("First_name"));
            }
     */

    }


}