package src.db;

import javax.swing.table.DefaultTableModel;
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
     * You have to use createConnection(), if you want to execute more than one methode use for an object.
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
            if (!rs.next()) {
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

    //  Creates table books with author and genre
    public DefaultTableModel createTableBooks() {
        String[] columnNames = {"Book Title", "Publishing Year", "Genre", "Quantity", "Author"};
        DefaultTableModel modelBookTable = new DefaultTableModel(columnNames, 0);
        Statement stmt = null;
        ResultSet rsBook = null;
        try {
            stmt = connection.createStatement();
            String sqlQuery = "Select Book.*, Author.firstname, Author.lastname from Book "
                    + "JOIN book_author ON Book.idBook = book_author.Book_idBook "
                    + "JOIN Author ON book_author.Author_idAuthor = Author.idAuthor";
            rsBook = stmt.executeQuery(sqlQuery);
            while (rsBook.next()) {
                String bookTitle = rsBook.getString("bookTitle");
                String pubYear = rsBook.getString("pubYear");
                String genre = getGenre(rsBook.getInt("Category_idCategory"));
                String quantity = rsBook.getString("quantity");
                String author = rsBook.getString("firstname") + " " + rsBook.getString("lastname");
                String[] data = {bookTitle, pubYear, genre, quantity, author};
                modelBookTable.addRow(data);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (rsBook != null) rsBook.close();
                if (connection != null) connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            return modelBookTable;
        }
    }


    //  Executes a SQL query and returns a ResultSet
    public ResultSet executeQuery(String sql) {
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            return stmt.executeQuery(sql);
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return null;
    }

    //  (General) Returns a table created from ResultSet and column names
    public DefaultTableModel createTableFromResultSet(ResultSet rs, String[] columns) {
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        try {
            while (rs.next()) {
                Object[] row = new Object[columns.length];
                for (int i = 0; i < columns.length; i++) {
                    row[i] = rs.getObject(i + 1);
                }
                model.addRow(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return model;
    }

    //  Searches in the database for the inputted author or book and returns a DefaultTableModel
    public DefaultTableModel searchBookAuthor(String searchTerm) {
        String[] columnNames = {"Book Title", "Publishing Year", "Genre", "Quantity", "Author"};
        DefaultTableModel modelBookTable = new DefaultTableModel(columnNames, 0);
        Statement stmt = null;
        ResultSet rsBook = null;
        try {
            stmt = connection.createStatement();
            String sqlQuery = "Select Book.*, Author.firstname, Author.lastname from Book "
                    + "JOIN book_author ON Book.idBook = book_author.Book_idBook "
                    + "JOIN Author ON book_author.Author_idAuthor = Author.idAuthor "
                    + "WHERE Book.bookTitle LIKE '%" + searchTerm
                    + "%' OR Author.firstname LIKE '%" + searchTerm
                    + "%' OR Author.lastname LIKE '%" + searchTerm
                    + "%'";
            rsBook = stmt.executeQuery(sqlQuery);
            while (rsBook.next()) {
                String bookTitle = rsBook.getString("bookTitle");
                String pubYear = rsBook.getString("pubYear");
                String genre = getGenre(rsBook.getInt("Category_idCategory"));
                String quantity = rsBook.getString("quantity");
                String author = rsBook.getString("firstname") + " " + rsBook.getString("lastname");
                String[] data = {bookTitle, pubYear, genre, quantity, author};
                modelBookTable.addRow(data);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (rsBook != null) rsBook.close();
                if (connection != null) connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            return modelBookTable;
        }
    }


    //  Method to get the right genre as a String
    private String getGenre(int idGenre) {
        String sqlInput = "Select genre FROM Category WHERE idCategory = " + idGenre + ";";
        String genre = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = connection.createStatement();
            rs = stmt.executeQuery(sqlInput);
            while (rs.next()) genre = rs.getString("genre");
            rs.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (rs != null) rs.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            return genre;
        }
    }

    //  Getters
    public Connection getConnection() {
        return this.connection;
    }


}