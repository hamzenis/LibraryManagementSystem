package src.db;

import javax.swing.table.DefaultTableModel;
import java.sql.*;

/**
 * Database Connection Class with various methods to get data in form of tables and insert data into the database.
 */
public class DBCon {

    //  Vars
    Connection connection = null;

    /**
     * Constructor with connection executed with creation of an object
     */
    public DBCon() {
        createConnection();
    }


    /**
     * Creates a connection to the database
     * Will be closed after every function from DBCon.
     * You have to use createConnection(), if you want to execute more than one methode use for an object.
     */
    public void createConnection() {

        try {
            //  Insert username(normally root) and password(set at MySQL installation) in Connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Library_Management_System", "root", "root");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /*
     *  SQL DML methods
     */

    /**
     * Executes a general insert, delete or change into the database
     *
     * @param inputSQL a string with a sql query
     */
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

    /**
     * Executes a SQL query and returns a ResultSet
     *
     * @param sql a string with the sql query
     * @return ResultSet returns a ResultSet with values
     */
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


    /**
     *   Gets Login credentials and returns if admin gui or user gui as an int:
     *  - 1 if Admin
     *  - 0 if User
     *  - -1 if the user is not existing int the database
     * @param id the id of the user from the mysql database
     * @param password the input of text flied entered value
     * @return returns the mode for the gui as an int
     */
    public int getUserMode(int id, String password) {
        int isLibrarian = -1;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String sqlQuery = "SELECT isLibrarian FROM User WHERE idUser = ? and password = ?";
            stmt = connection.prepareStatement(sqlQuery);
            stmt.setInt(1, id);
            stmt.setString(2, password);
            rs = stmt.executeQuery();
            if (rs.next()) {
                isLibrarian = rs.getInt("isLibrarian");
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return isLibrarian;
    }


    /**
     * Inserts User into database.
     *
     * @param values a string array with the in the input fields entered values
     * @return int returns the primary keys value from the mysql database
     */
    public int insertUser(String[] values) {
        PreparedStatement stmt1 = null;
        int generatedKey = -1;
        try {
            // Disable auto-commit mode
            connection.setAutoCommit(false);

            String userSQL = "INSERT INTO User (firstname, lastname, isLibrarian, password) VALUES ( ?, ?, ?, ?)";
            stmt1 = connection.prepareStatement(userSQL, Statement.RETURN_GENERATED_KEYS);
            stmt1.setString(1, values[0]);
            stmt1.setString(2, values[1]);
            if (values[2].equals("Administrator")) {
                stmt1.setInt(3, 1);
            } else {
                stmt1.setInt(3, 0);
            }
            stmt1.setString(4, values[3]);
            stmt1.executeUpdate();
            connection.commit();

            ResultSet generatedKeys = stmt1.getGeneratedKeys();
            if (generatedKeys.next()) {
                generatedKey = generatedKeys.getInt(1);
            }
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
            return generatedKey;
        }
    }


    /**
     * Inserts Book into database with author and genre.
     *
     * @param values a string array with the in the input fields entered values
     */
    public void insertBook(String[] values) {
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

    /*
     *       Table Methods
     */


    /**
     * Returns a genereal table created from ResultSet and column names
     *
     * @param rs
     * @param columns
     * @return
     */
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

    /**
     * Searches in the database for the inputted author or book and returns a DefaultTableModel
     *
     * @param searchTerm the search term in the textfield
     * @return a DefaultTableModel with the data in the rows
     */
    public DefaultTableModel searchBookAuthor(String searchTerm) {
        String[] columnNames = {"ID", "Book Title", "Publishing Year", "Genre", "Quantity", "Author"};
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
                String idBook = rsBook.getString("idBook");
                String bookTitle = rsBook.getString("bookTitle");
                String pubYear = rsBook.getString("pubYear");
                String genre = getGenre(rsBook.getInt("Category_idCategory"));
                String quantity = rsBook.getString("quantity");
                String author = rsBook.getString("firstname") + " " + rsBook.getString("lastname");
                String[] data = {idBook, bookTitle, pubYear, genre, quantity, author};
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

    /**
     * Creates table books with author and genre
     *
     * @return a DefaultTableModel with the data in the rows
     */
    public DefaultTableModel createTableBooks() {
        String[] columnNames = {"ID", "Book Title", "Publishing Year", "Genre", "Quantity", "Author"};
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
                String idBook = rsBook.getString("idBook");
                String bookTitle = rsBook.getString("bookTitle");
                String pubYear = rsBook.getString("pubYear");
                String genre = getGenre(rsBook.getInt("Category_idCategory"));
                String quantity = rsBook.getString("quantity");
                String author = rsBook.getString("firstname") + " " + rsBook.getString("lastname");
                String[] data = {idBook, bookTitle, pubYear, genre, quantity, author};
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

    /**
     * Creates a table for the issued books from a mysql database
     *
     * @return a DefaultTableModel with the data in the rows
     */
    public DefaultTableModel createTableIssuedBooks() {
        String[] columnNames = {"ID", "Renter", "Book Title", "Date of Issue"};
        DefaultTableModel modelTable = new DefaultTableModel(columnNames, 0);
        Statement stmt1 = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT idBorrow, User.firstname, User.lastname, Book.bookTitle, Borrow.dateOfBorrow "
                    + "FROM Borrow "
                    + "JOIN User ON User.idUser = Borrow.User_idUser "
                    + "JOIN Book ON Book.idBook = Borrow.Book_idBook ORDER BY idBorrow;";
            stmt1 = connection.createStatement();
            rs = stmt1.executeQuery(sql);
            while (rs.next()) {
                String idBorrow = rs.getString("idBorrow");
                String renter = rs.getString("firstname") + " " + rs.getString("lastname");
                String title = rs.getString("bookTitle");
                String date = rs.getDate("dateOfBorrow").toString();
                String[] values = {idBorrow, renter, title, date};
                modelTable.addRow(values);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            try {
                if (stmt1 != null) stmt1.close();
                if (rs != null) rs.close();
                if (connection != null) connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            return modelTable;
        }
    }

    /**
     * Creates a table for the returned books from a mysql database
     *
     * @return a DefaultTableModel with the data in the rows
     */
    public DefaultTableModel createTableReturnedBooks() {
        String[] columnNames = {"ID", "Renter", "Book Title", "Date of Issue", "Date of Return"};
        DefaultTableModel modelTable = new DefaultTableModel(columnNames, 0);
        Statement stmt1 = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT idReturned, User.firstname, User.lastname, Book.bookTitle, Returned.dateOfBorrow, Returned.dateOfReturn "
                    + "FROM Returned "
                    + "JOIN User ON User.idUser = Returned.User_idUser "
                    + "JOIN Book ON Book.idBook = Returned.Book_idBook ORDER BY idReturned DESC;";
            stmt1 = connection.createStatement();
            rs = stmt1.executeQuery(sql);
            while (rs.next()) {
                String idReturned = rs.getString("idReturned");
                String renter = rs.getString("firstname") + " " + rs.getString("lastname");
                String title = rs.getString("bookTitle");
                String dateBorrow = rs.getDate("dateOfBorrow").toString();
                String dateReturned = rs.getDate("dateOfReturn").toString();
                String[] values = {idReturned, renter, title, dateBorrow, dateReturned};
                modelTable.addRow(values);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            try {
                if (stmt1 != null) stmt1.close();
                if (rs != null) rs.close();
                if (connection != null) connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            return modelTable;
        }


    }

    /**
     * Creates a table for the issued books from a mysql database
     *
     * @param userId ID from user in the mysql database
     * @return a DefaultTableModel with the data in the rows
     */
    public DefaultTableModel createTableIssuedBooksUser(int userId) {
        String[] columnNames = {"ID", "Renter", "Book Title", "Date of Issue"};
        DefaultTableModel modelTable = new DefaultTableModel(columnNames, 0);
        Statement stmt1 = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT Borrow.idBorrow, User.firstname, User.lastname, Book.bookTitle, Borrow.dateOfBorrow "
                    + "FROM Borrow "
                    + "JOIN User ON User.idUser = Borrow.User_idUser "
                    + "JOIN Book ON Book.idBook = Borrow.Book_idBook "
                    + "WHERE User.idUser = " + userId + ";";
            stmt1 = connection.createStatement();
            rs = stmt1.executeQuery(sql);
            while (rs.next()) {
                String idBorrow = rs.getString("idBorrow");
                String renter = rs.getString("firstname") + " " + rs.getString("lastname");
                String title = rs.getString("bookTitle");
                String date = rs.getDate("dateOfBorrow").toString();
                String[] values = {idBorrow, renter, title, date};
                modelTable.addRow(values);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            try {
                if (stmt1 != null) stmt1.close();
                if (rs != null) rs.close();
                if (connection != null) connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            return modelTable;
        }
    }

    /*
     *       Getter methods
     */

    /**
     * Method to get the right genre as a String
     *
     * @param idGenre ID of the genre in the mysql database
     * @return Genre as a string
     */
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

    /**
     * Gets database connection
     *
     * @return A Connection for the database
     */
    //  Connection getter
    public Connection getConnection() {
        return this.connection;
    }


}