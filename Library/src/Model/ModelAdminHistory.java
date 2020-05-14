package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ModelAdminHistory {

    private Statement statement;

    public int getCountBooks(){
        int total = 0;
        try {
            String query = "SELECT COUNT(*) as Count FROM (kartu_pinjam k JOIN books b ON k.BookId = b.BookId) JOIN members m ON k.Email = m.Email " +
                    "ORDER BY k.NoCard DESC";
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
        String[][] data = new String[getCountBooks()][5];
        try{
            String query = "SELECT * FROM (kartu_pinjam k JOIN books b ON k.BookId = b.BookId) JOIN members m ON k.Email = m.Email " +
                    "ORDER BY k.NoCard DESC";
            statement = Database.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            int i = 0;
            while (resultSet.next()){
                data[i][0] = "" + (i+1);
                data[i][1] = resultSet.getString("BookTitle");
                data[i][2] = resultSet.getString("Email");
                data[i][3] = resultSet.getString("TglPinjam");
                data[i][4] = resultSet.getString("TglKembali");
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return data;
    }

    public String[][] getBookSearch(String book){
        try{
            int sumOfData = 0;
            int getSumOfData = 0;
            String query = "SELECT * FROM (kartu_pinjam k JOIN books b ON k.BookId = b.BookId) JOIN members m ON k.Email = m.Email " +
                    "WHERE b.BookTitle LIKE '%" + book + "%' " +
                    "ORDER BY k.NoCard DESC";
            statement = Database.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                getSumOfData++;
            }

            String[][] data = new String[getSumOfData][5];
            resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[sumOfData][0] = "" + (sumOfData+1);
                data[sumOfData][1] = resultSet.getString("BookTitle");
                data[sumOfData][2] = resultSet.getString("Email");
                data[sumOfData][3] = resultSet.getString("TglPinjam");
                data[sumOfData][4] = resultSet.getString("TglKembali");
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
