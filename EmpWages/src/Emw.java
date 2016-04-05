import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Emw {
  
  Connection con;
  Statement st;
  ResultSet rs;
  Scanner sc=new Scanner(System.in);
  
  
  void reg()
  {
   System.out.println("enter eid");
   String eid=sc.next();
   System.out.println("Enter the Employee name");
   String ename=sc.next();
   System.out.println("enter no of hours");
   String noh=sc.next();
   try 
   {
    String qry="insert into Emp(eid,ename,noh)values('"+eid+"','"+ename+"','"+noh+"')";
    int flag=st.executeUpdate(qry);
    if(flag!=0)
    {
     System.out.println("Registered Successfully!!!");
     rs=st.executeQuery("select eid from Emp where ename='"+ename+"'");
     while(rs.next())
     {
      System.out.println("Your employee id is:"+rs.getInt(1));
     }
    }
    else{
     System.out.println("Employee already Exists!!!!");
    }
    
   } catch (SQLException e) {
    e.printStackTrace();
   }
   
  }
  void getSalary()
  {
   int noh=0,sal=0;
   System.out.println("Enter the Employee ID");
   int eid=sc.nextInt();
   try {
     rs=st.executeQuery("select noh from Emp where eid="+eid);
     while(rs.next())
     {
      noh=rs.getInt(1);
     }
    }
     catch (SQLException e) {
    e.printStackTrace();
   }
   if(noh>40)
   {
    int temp=noh-40;
    sal=(40*100)+(temp*150);
   }
   else{
    sal=noh*100;
   }
   System.out.println("The total salary of employee id:"+eid+" is:"+sal);
   
  }

  void update()
  {
   System.out.println("Enter the Employee ID and Working hours");
   int eid=sc.nextInt();
   int noh=sc.nextInt();
   try {
     int flag=st.executeUpdate("UPDATE Emp SET noh="+noh+"  WHERE eid="+eid);
     if(flag!=0)
     System.out.println("Data updated successfully!!!");
     else
      System.out.println("No employee number found");
    }
     catch (SQLException e) {
    e.printStackTrace();
   }
   
  }

 public static void main(String[] args) 
 {
  Emw e=new Emw();
     boolean flag=true;
     e.sc=new Scanner(System.in);
     try 
     {
    Class.forName("org.sqlite.JDBC");
     e.con = DriverManager.getConnection("jdbc:sqlite:D:\\Jpgs\\Employee.sqlite");
      e.st=e.con.createStatement();
     } 
     catch ( Exception ex ) 
     {
    System.err.println( ex.getClass().getName() + ": " + ex.getMessage() );
     }
       System.out.println("Choose your option ");
       System.out.println("1.Register a employee");
       System.out.println("2.To get the Employee salary");
       System.out.println("3.To update the attendence");

       int option=e.sc.nextInt();
       switch(option)
       {
       case 1:e.reg();
         break;
       case 2:e.getSalary();
         break;
       case 3:e.update();
         break;
       case 4:flag=false;
         break;
       default:System.out.println("Invalid Input!!!");   
       }
        }

}