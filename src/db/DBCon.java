package src.db;

import java.sql.*;


/*  How to use:
 *      Create a DBCon Object and use the sqlExecute Function
 *
 */

// Debug query: insert into Author (First_name, Last_name) VALUES ('Hamzenis', 'Kryeziu');

public class DBCon {

    //  Vars
    Connection connection = null;

    //  Constructor with connection executed with creation of an object
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


    //  Give a SQL Query (DDL) to the function and it will be executed.
    public void sqlExecute(String inputSQL) {

        try {
            Statement statement = connection.createStatement();
            boolean resultSet = statement.execute(inputSQL);

            //  Debug
            System.out.println("Done SQL Execution! [DBcon.sqlExecute()]");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //  Prints Table Author in Terminal (Order: Firstname Lastname ID)
    public void printTableAuthor() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from Author");
            while (resultSet.next()) {
                System.out.println
                        (resultSet.getString("First_name")
                                + " "
                                + resultSet.getString("Last_name")
                                + " ID: "
                                + resultSet.getInt("idAuthor")
                        );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}