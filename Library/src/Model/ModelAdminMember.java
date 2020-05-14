package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ModelAdminMember {

    private Statement statement;

    public int getCountMembers(){
        int total = 0;
        try {
            String query = "SELECT COUNT(*) as Count FROM members";
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

    public String[][] getAllMembers(){
        String[][] data = new String[getCountMembers()][6];
        try{
            String query = "SELECT * FROM members";
            statement = Database.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            int i = 0;
            while (resultSet.next()){
                data[i][0] = "" + (i+1);
                data[i][1] = resultSet.getString("Email");
                data[i][2] = resultSet.getString("Name");
                data[i][3] = resultSet.getString("NoHp");
                data[i][4] = resultSet.getString("Address");
                data[i][5] = resultSet.getString("Password");
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return data;
    }

    public int updateMember(String email, String name, String noHp, String address, String password){
        int result = 0;
        try {
            String query = "UPDATE members SET " +
                    "Name = '" + name + "', NoHp = '" + noHp + "', Address = '" + address + "', Password = '" + password + "' " +
                    "WHERE Email = '" + email + "'";
            statement = Database.getConnection().createStatement();
            statement.executeUpdate(query);
            result = 1;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return result;
    }

    public int deleteMember(String email){
        int result = 0;
        try {
            String query = "DELETE FROM members WHERE Email = '" + email + "'";
            statement = Database.getConnection().createStatement();
            statement.executeUpdate(query);
            result = 1;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return result;
    }

    public String[][] getMemberSearch(String email){
        try{
            int getSumOfData = 0;
            String query = "SELECT * FROM members WHERE Email LIKE '%" + email + "%'";
            statement = Database.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                getSumOfData++;
            }

            String[][] data = new String[getSumOfData][6];
            resultSet = statement.executeQuery(query);
            int i = 0;
            while (resultSet.next()){
                data[i][0] = "" + (i+1);
                data[i][1] = resultSet.getString("Email");
                data[i][2] = resultSet.getString("Name");
                data[i][3] = resultSet.getString("NoHp");
                data[i][4] = resultSet.getString("Address");
                data[i][5] = resultSet.getString("Password");
                i++;
            }
            return data;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return null;
        }
    }
}
