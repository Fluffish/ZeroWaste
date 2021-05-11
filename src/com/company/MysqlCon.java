package com.company;
import java.sql.*;

class MysqlCon{
    public static void main(String args[]){
        try{
            //Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/zerowaste","Florent","H4n4g4subarash&");

            System.out.println("Connected to the database!");


            PreparedStatement stmt = con.prepareStatement("INSERT INTO test_storage(storage_name, storage_temp) VALUES (?, ?)");
            stmt.setString(1, "Placard");
            stmt.setInt(2, 20);


            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("A row has been inserted");
            }
            //while(rs.next())
                //System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));

            stmt.close();
            con.close();

        }
        catch(Exception e){
            System.out.println("Oops, error!");
            e.printStackTrace();}
    }
}