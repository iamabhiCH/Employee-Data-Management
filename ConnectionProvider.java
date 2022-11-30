// Class for provide the connection with the database..
/*
    By the using of this class we don't need to write the whole code that is given in every class.
    We can use this class in any class for creating connection with database. We only need to use
    this class name or function name for create connection with database.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConnectionProvider {
    private static Connection con;

    public static Connection getConnection(){

        try{
            if(con == null){
                Class.forName("com.mysql.jdbc.Driver");

                String url = "jdbc:mysql://localhost:3306/employee?characterEncoding=latin1";
                String username = "root";
                String pass = "root9771";

                con = DriverManager.getConnection(url,username,pass);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return con;
    }
}
