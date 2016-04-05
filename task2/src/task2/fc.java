package task2;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class fc {

	Connection con;
	  Statement st;
	  ResultSet rs;
	  Scanner s=new Scanner(System.in);
	  
	  
	  void reg()
	  {
		  System.out.println("Enter the Employee IDNO which should be unique");
		   int eid=s.nextInt();
	   System.out.println("Enter the Employee NAME");
	   String ename=s.next();
	   
	   
	   try {
	    String qry="INSERT INTO emp(eid,ename) VALUES('"+eid+"','"+ename+"')";
	    int flag=st.executeUpdate(qry);
	    
	    if(flag!=0)
	    {
	     System.out.println("Registered Successfully!!!");
	     rs=st.executeQuery("select eid from emp where ename='"+ename+"' ");
	     
	    }
	    else{
	     System.out.println("Employee already Exists!!!!");
	    }
	    
	   } catch (SQLException e) {
	    e.printStackTrace();
	   }
	   
	  }
	  void preg()
	  {
	   System.out.println("enter pid");
	   int pid=s.nextInt();
	   System.out.println("Enter the Project name");
	   String pname=s.next();
	  
	   try 
	   {
	    String qry="insert into project(pid,pname)values('"+pid+"','"+pname+"')";
	    int flag=st.executeUpdate(qry);
	    if(flag!=0)
	    {
	     System.out.println("Registered Successfully!!!");
	     rs=st.executeQuery("select pid from project where pname='"+pname+"'");
	     while(rs.next())
	     {
	      System.out.println("Your project id is:"+rs.getInt(1));
	     }
	    }
	    else{
	     System.out.println("Project Id already Exists!!!!");
	    }
	    
	   } catch (SQLException e) {
	    e.printStackTrace();
	   }
	   
	  }
	  void att()
	  {
	   System.out.println("Enter the Employee ID");
	   int eid=s.nextInt();
	   System.out.println("Enter the date in mm-dd-yyyy format");
	   String dt=s.next();
	   Date date=null;
	   SimpleDateFormat sdf=new SimpleDateFormat("MM-dd-yyyy");
	   
	   try {
	    date = sdf.parse(dt);
	    Date date2 = new Date();
	    date2 = sdf.parse(sdf.format(new Date()));
	    DateFormat destDf = new SimpleDateFormat("yyyy-MM-dd");
	    String dateStr = destDf.format(date);
	    if(!date2.before(date))
	    {
	     System.out.println("Enter the Project ID");
	     int pid=s.nextInt();
	     System.out.println("Enter the working Hours");
	     int noh=s.nextInt();
	     
	     String qry="SELECT SUM(noh) from att where eid="+eid+" and date='"+dateStr+"' group by eid,date ";
	     rs=st.executeQuery(qry);
	     int t_hrs=0;
	     while(rs.next())
	     {
	      t_hrs=rs.getInt(1);
	     }
	     if((t_hrs+noh)<=8)
	     {
	      qry="INSERT INTO atten(eid,pid,noh,date) VALUES("+eid+",'"+dateStr+"',"+pid+","+noh+")";
	      int flag=st.executeUpdate(qry);
	      if(flag!=0)
	      {
	       System.out.println("Updated Successfully!!!");
	      }
	      else{
	       System.out.println("Not Updated!!!!");
	      }
	     }
	     else{
	      System.out.println("total working hours should be less then 8 per day ");
	      }
	     }
	     else{
	       System.out.println("Date should not be future date!!!");
	     }
	    } catch (Exception e) {
	     e.printStackTrace();
	   }
	     
	  }
	  void wReport()
	  {
	   System.out.println("Enter the employee ID");
	   int id1=s.nextInt();
	    System.out.println("Enter the start date of week in format:mm-dd-yyyy");
	     String sdate=s.next();
	     System.out.println("Enter the end date of week in format:mm-dd-yyyy");
	     String edate=s.next();
	     try {
	         
	         SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
	          
	           Date date1=sdf.parse(sdate);
	           Date date2=sdf.parse(edate);
	           DateFormat destDf = new SimpleDateFormat("yyyy-MM-dd");
	     String dateStr1 = destDf.format(date1);
	     String dateStr2 = destDf.format(date2);
	           String qry="SELECT eid,pid,noh,date from att where eid="+id1+" and date >= '"+dateStr1+"' and date<='"+dateStr2+"'";
	           rs=st.executeQuery(qry);
	           System.out.println("The weekly Report is:");
	           while(rs.next())
	           {
	            int eid=rs.getInt(1);
	            int pid=rs.getInt(2);
	            int noh=rs.getInt(3);
	            String date=rs.getString(4);
	            System.out.println(" "+eid+"\t"+pid+"\t"+noh+"\t"+date);
	           }
	     }
	      catch(Exception ex){
	               ex.printStackTrace();
	            } 
	     
	  }
	  void mReport()
	  {
	   System.out.println("Enter the employee ID");
	   int id1=s.nextInt();
	   System.out.println("Enter year and month in format:yyyy-mm");
	     String mnth=s.next();
	     String dateStr1=mnth+"01";
	     String dateStr2=mnth+"31";
	     try {
	           String qry="SELECT eid,pid,noh,date from att where eid="+id1+" and date>='"+dateStr1+"' and date <='"+dateStr2+"'";
	           rs=st.executeQuery(qry);
	           System.out.println("The monthly Report is:");
	           while(rs.next())
	           {
	        	   int eid=rs.getInt(1);
		            int pid=rs.getInt(2);
		            int noh=rs.getInt(3);
		            String date=rs.getString(4);
		            System.out.println(" "+eid+"\t"+pid+"\t"+noh+"\t"+date);
	           }
	      }
	      catch(Exception ex){
	               ex.printStackTrace();
	            } 
	  }
	  public static void main(String[] args)
		{
			demo d=new demo();
		     boolean flag=true;
		     d.s=new Scanner(System.in);
		     try 
		     {
		    Class.forName("org.sqlite.JDBC");
		     d.con = DriverManager.getConnection("jdbc:sqlite:D:\\Jpgs\\db\\week.sqlite");
		      d.st=d.con.createStatement();
		     } 
		     catch ( Exception ex ) 
		     {
		    System.err.println( ex.getClass().getName() + ": " + ex.getMessage() );
		     }
		     do{
		    	    System.out.println("Enter the option ");
		    	    System.out.println("1.Register a employee");
		    	    System.out.println("2.To enter project details");
		    	    System.out.println("3. Enter att details");
		    	    System.out.println("4.To get weekly report");
		    	    System.out.println("5.To get monthly report");
		    	    System.out.println("6.To Exit");
		    	    int option=d.s.nextInt();
		    	    switch(option)
		    	    {
		    	    case 1:d.reg();
		    	      break;
		    	    case 2: d.preg();
		    	    break;
		    	    case 3: d.att();
		    	    break;
		    	    case 4:d.week();
		    	      	break;	
		    	    case 5:d.month();
		    	    break;
		    	  
		    	    case 6:flag=false;
		    	      break;
		    	    default:System.out.println("Invalid Input!!!");   
		    	    }
		     }while(flag);
		}
}
