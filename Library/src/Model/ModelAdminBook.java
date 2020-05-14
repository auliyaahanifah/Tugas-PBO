package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ModelAdminBook {
    private Statement statement;

    public int getCountBooks(){
        int total = 0;
        try {
            String query = "SELECT COUNT(*) as Count FROM books";
            statement = Database.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()){
                total = resultSet.getInt("Count");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return total;
    }

    public String[][] getAllBooks(){
        String[][] data = new String[getCountBooks()][6];
        try{
            String query = "SELECT * FROM books ORDER BY BookTitle ASC";
            statement = Database.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            int i = 0;
            while (resultSet.next()){
                data[i][0] = resultSet.getString("BookId");
                data[i][1] = "" + (i+1);
                data[i][2] = resultSet.getString("BookTitle");
                data[i][3] = resultSet.getString("Author");
                data[i][4] = resultSet.getString("Genre");
                data[i][5] = resultSet.getString("Stock");
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return data;
    }

    public int insertBook(String bookTitle, String author,
                          String genre, String stock){
        int result = 0;
        try {
            String query = "INSERT INTO books VALUES " +
                    "(DEFAULT, '" + bookTitle + "', '" +
                    author + "', '" + genre + "', " + stock + ")";
            statement = Database.getConnection().createStatement();
            statement.executeUpdate(query);
            result = 1;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            result = 0;
        }
        return result;
    }

    public int updateBook(String bookId, String bookTitle, String author, String genre, String stock){
        int result = 0;
        try {
            String query = "UPDATE books SET " +
                    "BookTitle = '" + bookTitle + "', Author = '" + author + "', Genre = '" + genre + "', Stock = " + stock + " " +
                    "WHERE BookId = " + bookId;
            statement = Database.getConnection().createStatement();
            statement.executeUpdate(query);
            result = 1;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            result = 0;
        }
        return result;
    }

    public int deleteBook(String bookId){
        int result = 0;
        try {
            String query = "DELETE FROM books WHERE BookId = " + bookId;
            statement = Database.getConnection().createStatement();
            statement.executeUpdate(query);
            result = 1;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            result = 0;
        }
        return result;
    }

    public String[][] getBookSearch(String book){
        try{
            int sumOfData = 0;
            int getSumOfData = 0;
            String query = "SELECT * FROM books WHERE BookTitle LIKE '%" + book + "%' ORDER BY BookTitle ASC";
            statement = Database.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                getSumOfData++;
            }

            String[][] data = new String[getSumOfData][6];
            resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[sumOfData][0] = resultSet.getString("BookId");
                data[sumOfData][1] = "" + (sumOfData+1);
                data[sumOfData][2] = resultSet.getString("BookTitle");
                data[sumOfData][3] = resultSet.getString("Author");
                data[sumOfData][4] = resultSet.getString("Genre");
                data[sumOfData][5] = resultSet.getString("Stock");
                sumOfData++;
            }
            return data;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return null;
        }
    }
}
