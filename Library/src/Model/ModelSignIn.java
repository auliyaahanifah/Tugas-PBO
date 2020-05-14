package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ModelSignIn {
    private Statement statement;

    public String[] getMember(String email, String password){
        String data[] = new String[2];
        try {
            String query = "SELECT * FROM members " +
                    "WHERE Email = '" + email + "' AND Password = '" + password + "'";
            statement = (Statement) Database.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()){
                data[0] = resultSet.getString("Email");
                data[1] = resultSet.getString("Name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return data;
    }

    public int getCountForSignIn(String email, String password){
        int count = 0;
        try {
            String query = "SELECT COUNT(*) as count FROM members " +
                    "WHERE Email = '" + email + "' AND Password = '" + password + "'";
            statement = (Statement) Database.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next())
                count = resultSet.getInt("count");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return count;
    }

    public int checkAlreadyMembers(String email){
        int count = 0;
        try {
            String query = "SELECT COUNT(*) as count FROM members " +
                    "WHERE Email = '" + email + "'";
            statement = (Statement) Database.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next())
                count = resultSet.getInt("count");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return count;
    }

    public int insertMember(String email, String name, String noHp, String address, String password){
        int count = 0;
        try {
            if (checkAlreadyMembers(email) == 0){
                String query = "INSERT INTO members VALUES" +
                        "('" + email + "','" + name + "','" + noHp + "','" + address + "','" + password + "')";
                statement = (Statement) Database.getConnection().createStatement();
                statement.executeUpdate(query);
                count = 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return count;
    }
}
