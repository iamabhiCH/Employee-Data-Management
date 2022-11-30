// Class for creating table to store the information of employees
// If you create a new table please run this class individually once for create a new table in your database....
// Please don't run this class until you not needed a new table in your database and don't forget to change the table name
import java.sql.Connection;
import java.sql.Statement;

public class CreateTable {
    public static void TableInfo(){
        try{
            Connection con = ConnectionProvider.getConnection();

            String q = "create table emp(eID int(200) primary key auto_increment, eName varchar(2000) not null, father_name varchar(2000) not null,"+
                    "gender varchar(500) not null, dob varchar(1000) not null, email varchar(4000) not null, phone varchar(1200) not null," +
                    "eRole varchar(2000), eSal int(200) not null)";

            // Create a statement

            Statement stmt = con.createStatement();
            stmt.executeUpdate(q);
            System.out.println("table created in database ");
            con.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        TableInfo();
    }
}
