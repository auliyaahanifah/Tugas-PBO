package contact_mvc;

import javax.swing.*;
import java.sql.*;

public class Model {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/dbcontactt";
    static final String USER = "root";
    static final String PASS = "";

    Connection koneksi;
    Statement statement;

    public Model(){
        try {
            Class.forName(JDBC_DRIVER);
            koneksi = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.println("Koneksi Gagal");
        }
    }

    public void insertContact (String nama, String no_hp, String umur, String email){
        try {
            String query = "INSERT INTO `contact` (`nama`,`no_hp`,`umur`,`email`)"
                    + "VALUES ('"+nama+"', '"+no_hp+"', '"+umur+"', '"+email+"')";
            statement = (Statement) koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "BERHASIL INSERT");
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public String[][] readContact(){
        int jmlData = 0;
        try {
            String data[][] = new String[getContact()][5];
            String query = "SELECT * FROM contact";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[jmlData][0] = resultSet.getString("nama");
                data[jmlData][1] = resultSet.getString("no_hp");
                data[jmlData][2] = resultSet.getString("umur");
                data[jmlData][3] = resultSet.getString("email");
                data[jmlData][4] = resultSet.getString("id");
                jmlData++;
            }return data;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL ERROR");
            return null;
        }
    }

    public int getContact(){
        int jmlData = 0;
        try {
            statement = (Statement) koneksi.createStatement();
            String query = "SELECT * FROM contact";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                jmlData++;
            }return  jmlData;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL ERROR");
            return  0;
        }
    }

    public void hapusContact(String id){
        try {
            statement = (Statement) koneksi.createStatement();
            String query = "DELETE FROM contact WHERE `id` = '"+id+"'";
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "BERHASIL HAPUS");
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.println("DATA TIDAK ADA");
        }
    }

    public void updateContact (String id, String nama, String no_hp, String umur, String email){
        try {
            statement = (Statement) koneksi.createStatement();
            String query = "UPDATE `contact` SET `nama` ='"+nama+"', `no_hp` ='"+no_hp+"', `umur` ='"+umur+"', `email` ='"+email+"' "+"WHERE `id` = '"+id+"'";
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "KONTAK BERHASIL UPDATE");
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public int getAllContactSearch (String cari){
        int jmlData = 0;
        try {
            statement = (Statement) koneksi.createStatement();
            String query = "SELECT * FROM contact Where nama like '%"+cari+"%' OR no_hp like '%"+cari+"%' ";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                jmlData++;
            }return jmlData;
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "KONTAK TIDAK ADA DALAM PENCARIAN");
            return  0;
        }
    }

    public String[][] getContactSearch (String cari){
        try {
            int jmlData = 0;
            String data[][] = new String[getAllContactSearch(cari)][5];
            String query = "SELECT * FROM contact WHERE nama like '%"+cari+"%' OR no_hp like '%"+cari+"%' ";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[jmlData][0] = resultSet.getString("nama");
                data[jmlData][1] = resultSet.getString("no_hp");
                data[jmlData][2] = resultSet.getString("umur");
                data[jmlData][3] = resultSet.getString("email");
                data[jmlData][4] = resultSet.getString("id");
                jmlData++;
            }return data;
        }catch (SQLException e){
            return null;
        }
    }
}
