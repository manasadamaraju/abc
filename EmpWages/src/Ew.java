import java.sql.*;
import java.util.Scanner;

public class Ew {
	Scanner sc;
	Connection con;
	Statement st;
	public void register()
	{
		try{
		System.out.println("enter the id:");
		int eid=sc.nextInt();
		System.out.println("enter the name:");
		String ename=sc.nextLine();
		System.out.println("enter the no of hours:");
		int noh=sc.nextInt();
		 st = con.createStatement();
		 String str="INSERT INTO Emp(eid,ename,noh)VALUES(+eid +ename  +noh)";
		 st.executeUpdate(str);
		 System.out.println("inserted successfully");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void getSal()
	{
		System.out.println("enter the id:");
		int n=sc.nextInt();
		String str1=st.executeQuery("select * from Emp where eid=+n");
		if(n<=40)
		{
			int s=n*100;
			System.out.println()
		}
	}
	
	

	public static void main(String[] args)throws SQLException {
		  // TODO Auto-generated method stub
		    Ew t1=new Ew();
		    boolean flag=true;
		    t1.sc=new Scanner(System.in);
		    
		    

		    System.out.println("Enter the option ");
		    System.out.println("1.Register a employee");
		    System.out.println("2.To get the Employee salary");
		    System.out.println("3.To update the attendence");

		    int option=t1.sc.nextInt();
		    switch(option)
		    {
		    case 1:t1.register();
		      break;
		    case 2:t1.getSal();
		      break;
		    case 3:t1.update();
		      break;
		    case 4:flag=false;
		      break;
		    default:System.out.println("Invalid Input!!!");   
		    }
		    
		     }
}
