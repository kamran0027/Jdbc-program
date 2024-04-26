package src;
import com.mysql.jdbc.Driver;

import javax.management.Query;
import java.sql.*;
public class Main {
    public static void main(String[] args) throws ClassNotFoundException{

        //database info
        String url="jdbc:mysql://localhost:3306/kamrandb";
        String user="root";
        String password="Kamran098@";

        String query="select * from employee";
        try {

            //load the driver
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("try block loaded succesfully");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {

            //building the connection to the database
          Connection con= DriverManager.getConnection(url,user,password);
            System.out.println("connection stablish successfully");
            //making statement
            Statement stmt=con.createStatement();


            //storing the fetch values from database to the resultset
            ResultSet rs=stmt.executeQuery(query);
//            int rowsAffeceted=stmt.executeUpdate(Operation.insrt);
//            if (rowsAffeceted>0){
//                System.out.println("insert successefully");
//            }
//            else {
//                System.out.println("insert failed");
//            }

            while (rs.next()){
                int id=rs.getInt("id");
                String name=rs.getString("name");
                double salary=rs.getDouble("salary");

                System.out.println("*************************************");
                System.out.println("id: "+id);
                System.out.println("name: "+name);
                System.out.println("salary: "+salary);
            }
            //close the resource
            rs.close();
            stmt.close();
            con.close();
            System.out.println();
            System.out.println("connection close succesfully");
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
