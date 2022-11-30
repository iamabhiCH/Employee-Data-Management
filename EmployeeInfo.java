// Class for Inserting the information of employees in the database......

// Importing packages
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

// Creating class
public class EmployeeInfo {
    // Creating  function for insert the data
    public static void InsertInfo(){
        try{
            // Creating connection with the database
            Connection con = ConnectionProvider.getConnection();

            // Insert Info
            String dq = "insert into emp(eName,father_name,gender,dob,email,phone,eRole,eSal) values(?,?,?,?,?,?,?,?)";

            PreparedStatement pstmt = con.prepareStatement(dq);

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Enter Employee name : ");
            String name = br.readLine();
            System.out.print("Enter Employee's father's name : ");
            String fname = br.readLine();
            System.out.print("Enter Employee gender : ");
            String g = br.readLine();
            System.out.print("Enter Employee Date of Birth : ");
            String  dob = br.readLine();
            System.out.print("Enter Employee's email : ");
            String email = br.readLine();
            System.out.print("Enter Employee's contact no : ");
            String phn = br.readLine();
            System.out.print("Enter Employee's role in company : ");
            String role = br.readLine();
            System.out.print("Enter Employee's salary : ");
            int sal = Integer.parseInt(br.readLine());

            // Set the values of query
            pstmt.setString(1,name);
            pstmt.setString(2,fname);
            pstmt.setString(3,g);
            pstmt.setString(4,dob);
            pstmt.setString(5,email);
            pstmt.setString(6,phn);
            pstmt.setString(7,role);
            pstmt.setInt(8,sal);

            pstmt.executeUpdate();
            System.out.println("\n Employee data inserted..........");
            con.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    // Function for display the data of employees
    public static void DisplayDetails(){
        try{
            // Create connection with database
            Connection con = ConnectionProvider.getConnection();

            // Declaring query
            String query = "select * from emp";

            Statement stmt = con.createStatement();
            ResultSet set = stmt.executeQuery(query);

            while(set.next()){
                int id = set.getInt(1);
                String Name = set.getString(2);
                String f_Name = set.getString(3);
                String gender = set.getString(4);
                String dob = set.getString(5);
                String email = set.getString(6);
                String phn = set.getString(7);
                String role = set.getString(8);
                int sal = set.getInt(9);
                System.out.println(id + " : " + Name+" : "+f_Name+" : "+gender+" : "+dob+" : "+email+" : "+phn+" : "+role+" : "+sal);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    // Creating class for update the employee data
    public static void UpdateInfo(){

        System.out.println("\n\nHere are the employee key information.\nWhat do you want to update please choose..." );
        System.out.println("\n1. Name \t 2. Father's Name \n3. Gender \t 4. Date of Birth \n5. Email Id \t 6. Contact Number" +
                "\n7. Employee Role \t 8. Salary");
        Scanner t = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try{
            Connection con = ConnectionProvider.getConnection();
            System.out.print("Enter Your Choice : ");
            int ch = t.nextInt();

            switch (ch){
                case 1:
                    String q = "update emp set eName=? where eId = ?";
                    System.out.print("Enter Id of employee : ");
                    int id = Integer.parseInt(br.readLine());
                    System.out.print("Enter new name of employee : ");
                    String Name = br.readLine();

                    PreparedStatement pstmt = con.prepareStatement(q);
                    pstmt.setString(1,Name);
                    pstmt.setInt(2,id);

                    pstmt.executeUpdate();
                    System.out.println("Employee Name changed.....");
                    con.close();
                    break;
                case 2:
                    String q1 = "update emp set eName=?, father_name=? where eId = ?";
                    System.out.print("Enter Id of employee : ");
                    int id1 = Integer.parseInt(br.readLine());
                    System.out.print("Enter name of employee : ");
                    String name = br.readLine();
                    System.out.print("Enter Father name for update : ");
                    String fname = br.readLine();

                    PreparedStatement pstmt1 = con.prepareStatement(q1);
                    pstmt1.setString(1,name);
                    pstmt1.setString(2,fname);
                    pstmt1.setInt(3,id1);

                    pstmt1.executeUpdate();
                    System.out.println("Employee's Father Name changed.....");
                    con.close();
                    break;
                case 3:
                    String q2 = "update emp set eName=?, gender=? where eId = ?";
                    System.out.print("Enter Id of employee : ");
                    int id2 = Integer.parseInt(br.readLine());
                    System.out.print("Enter name of employee : ");
                    String name1 = br.readLine();
                    System.out.print("Enter gender of employee : ");
                    String g = br.readLine();

                    PreparedStatement pstmt2 = con.prepareStatement(q2);
                    pstmt2.setString(1,name1);
                    pstmt2.setString(2,g);
                    pstmt2.setInt(3,id2);

                    pstmt2.executeUpdate();
                    System.out.println("Employee Gender changed.....");
                    con.close();
                    break;
                case 4:
                    String q3 = "update emp set eName=?, dob=? where eId = ?";
                    System.out.print("Enter Id of employee : ");
                    int id3 = Integer.parseInt(br.readLine());
                    System.out.print("Enter name of employee : ");
                    String name2 = br.readLine();
                    System.out.print("Enter correct Date of Birth : ");
                    String dob = br.readLine();

                    PreparedStatement pstmt3 = con.prepareStatement(q3);
                    pstmt3.setString(1,name2);
                    pstmt3.setString(2,dob);
                    pstmt3.setInt(3,id3);

                    pstmt3.executeUpdate();
                    System.out.println("Employee Date of Birth changed.....");
                    con.close();
                    break;
                case 5:
                    String q4 = "update emp set eName=?, email=? where eId = ?";
                    System.out.print("Enter Id of employee : ");
                    int id4 = Integer.parseInt(br.readLine());
                    System.out.print("Enter name of employee : ");
                    String name3 = br.readLine();
                    System.out.print("Enter new email id of employee : ");
                    String email = br.readLine();

                    PreparedStatement pstmt4 = con.prepareStatement(q4);
                    pstmt4.setString(1,name3);
                    pstmt4.setString(2,email);
                    pstmt4.setInt(3,id4);

                    pstmt4.executeUpdate();
                    System.out.println("Employee Email Id changed.....");
                    con.close();
                    break;
                case 6:
                    String q5 = "update emp set eName=?, phone=? where eId = ?";
                    System.out.print("Enter Id of employee : ");
                    int id5 = Integer.parseInt(br.readLine());
                    System.out.print("Enter name of employee : ");
                    String name4 = br.readLine();
                    System.out.print("Enter new contact number of employee : ");
                    String cntNo = br.readLine();

                    PreparedStatement pstmt5 = con.prepareStatement(q5);
                    pstmt5.setString(1,name4);
                    pstmt5.setString(2,cntNo);
                    pstmt5.setInt(3,id5);

                    pstmt5.executeUpdate();
                    System.out.println("Employee Contact No changed.....");
                    con.close();
                    break;
                case 7:
                    String q6 = "update emp set eName=?, eRole=? where eId = ?";
                    System.out.print("Enter Id of employee : ");
                    int id6 = Integer.parseInt(br.readLine());
                    System.out.print("Enter name of employee : ");
                    String name5 = br.readLine();
                    System.out.print("Enter new role of employee : ");
                    String role = br.readLine();

                    PreparedStatement pstmt6 = con.prepareStatement(q6);
                    pstmt6.setString(1,name5);
                    pstmt6.setString(2,role);
                    pstmt6.setInt(3,id6);

                    pstmt6.executeUpdate();
                    System.out.println("Employee New Role Assigned.....");
                    con.close();
                    break;
                case 8:
                    String q7 = "update emp set eName=?, eSal=? where eId = ?";
                    System.out.print("Enter Id of employee : ");
                    int id7 = Integer.parseInt(br.readLine());
                    System.out.print("Enter name of employee : ");
                    String name6 = br.readLine();
                    System.out.print("Enter new Salary of employee : ");
                    int sal = Integer.parseInt(br.readLine());

                    PreparedStatement pstmt7 = con.prepareStatement(q7);
                    pstmt7.setString(1,name6);
                    pstmt7.setInt(2,sal);
                    pstmt7.setInt(3,id7);

                    pstmt7.executeUpdate();
                    System.out.println("Employee Salary Updated.....");
                    con.close();
                    break;
                default:
                    System.out.println("\n Invalid Choice.......");
                    break;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    // Creating class for delete the information of employee who leave the organization...
    public static void DeleteInfo(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            Connection con = ConnectionProvider.getConnection();

            String q = "delete from emp where eID=?";

            PreparedStatement pstmt = con.prepareStatement(q);
            System.out.print("\nEnter employee id for delete information : ");
            int id = Integer.parseInt(br.readLine());
            pstmt.setInt(1,id);

            int i = pstmt.executeUpdate();

            if(i > 0){
                System.out.println("Employee Data Deleted........");
            }
            else{
                System.out.println("Not found in database.........");
            }
            con.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
