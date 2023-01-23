package src.db;

import java.sql.*;

public class DBCon {

    //  Vars
    Connection connection = null;

    //  Constructor with connection executed with creation of an object
    public DBCon() {
        createConnection();
    }


    /*
     * Don't have to be executed the first time, because it's executed in the constructor.
     * Will be closed after every function from DBCon.
     *
     */
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
        Statement statement = null;
        try {
            statement = connection.createStatement();
            boolean resultSet = statement.execute(inputSQL);
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                }
            }
        }
    }


    //  inserts User into database
    public void insertUser(String values[]) {
        PreparedStatement stmt1 = null;
        try {
            // Disable auto-commit mode
            connection.setAutoCommit(false);

            String userSQL = "INSERT INTO User (firstname, lastname, isLibrarian) VALUES ( ?, ?, ?)";
            stmt1 = connection.prepareStatement(userSQL);
            stmt1.setString(1, values[0]);
            stmt1.setString(2, values[1]);
            if (values[2].equals("Administrator")) {
                stmt1.setInt(3, 1);
            } else {
                stmt1.setInt(3, 0);
            }
            stmt1.executeUpdate();
            connection.commit();

        } catch (SQLException se) {
            se.printStackTrace();
            // If there is an error, rollback the transaction
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } finally {
            try {
                if (stmt1 != null) stmt1.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //  inserts Book into database with author and genre
    public void insertBook(String values[]) {

        PreparedStatement stmt1 = null;
        PreparedStatement stmt2 = null;
        PreparedStatement stmt3 = null;
        PreparedStatement stmt4 = null;

        try {
            // Disable auto-commit mode
            connection.setAutoCommit(false);

            //  Book table
            String bookSQL = "INSERT INTO Book (bookTitle, pubYear, quantity, Category_idCategory) " +
                    "VALUES (?, ?, ?, (SELECT idCategory FROM Category WHERE genre = ?))";
            stmt1 = connection.prepareStatement(bookSQL);
            stmt1.setString(1, values[2]);
            stmt1.setDate(2, Date.valueOf(values[3]));
            stmt1.setInt(3, Integer.parseInt(values[5]));
            stmt1.setString(4, values[4]);
            stmt1.executeUpdate();

            // Author table
            String checkAuthorSQL = "SELECT idAuthor FROM Author WHERE firstname = ? and lastname = ?";
            stmt3 = connection.prepareStatement(checkAuthorSQL);
            stmt3.setString(1, values[0]);
            stmt3.setString(2, values[1]);
            ResultSet rs = stmt3.executeQuery();
            int authorId = -1;
            if (rs.next()) {
                //  Nothing will be done
            } else {
                String authorSQL = "INSERT INTO Author (firstname, lastname) VALUES (?, ?)";
                stmt2 = connection.prepareStatement(authorSQL);
                stmt2.setString(1, values[0]);
                stmt2.setString(2, values[1]);
                stmt2.executeUpdate();
            }

            //  Book-Author table
            String bookAuthorSQL = "INSERT INTO book_author (Author_idAuthor, Book_idBook) " +
                    "VALUES ((SELECT idAuthor FROM Author WHERE firstname = ? and lastname = ?), (SELECT idBook FROM Book WHERE bookTitle = ?))";
            stmt4 = connection.prepareStatement(bookAuthorSQL);
            stmt4.setString(1, values[0]);
            stmt4.setString(2, values[1]);
            stmt4.setString(3, values[2]);
            stmt4.executeUpdate();

            connection.commit();

        } catch (SQLException se) {
            se.printStackTrace();

            // If there is an error, rollback the transaction
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } finally {

            try {
                if (stmt4 != null) stmt4.close();
                if (stmt3 != null) stmt3.close();
                if (stmt2 != null) stmt2.close();
                if (stmt1 != null) stmt1.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    //  Getters
    public Connection getConnection() {
        return this.connection;
    }


}