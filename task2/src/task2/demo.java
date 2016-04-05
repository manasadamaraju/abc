package task2;


import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;


public class demo {


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
	   try
	   {
	   System.out.println("Enter the Employee ID");
	   int eid=s.nextInt();
	   System.out.println("Enter the PROJECT NO");
	   int pid=s.nextInt();
	   System.out.println("Enter the Working hours for project ");
	   int noh=s.nextInt();
	   
	   SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
	   System.out.println("Enter the DATE in format:mm-dd-yyyy");
	   String date=s.next();
	   Date date1=sdf.parse(date);
	   Date date2 = new Date();
	   date2 = sdf.parse(sdf.format(new Date()));
	   int a=0;
	   rs=st.executeQuery("select sum(noh) from att where eid="+eid+" and date='"+date+"'");
	   while(rs.next())
	   {
	 	  a=rs.getInt(1); 
	   }
	 
	   if(a>0||a<=8)
	   {
	      int b=8-a;
	      if(noh<=b)
	      {	 
	 	  if(date1.before(date2))
	 	  {	
	 		  int flag=st.executeUpdate("INSERT INTO att(eid,pid,noh,date) VALUES("+eid+",'"+pid+"',"+noh+",'"+date1+"')");
	 		  if(flag!=0)
	 			  System.out.println("Data updated successfully!!!");
	 		  else
	 			  System.out.println("employee id invalid");
	 	  }
	 	  else System.out.println("date is invalid....");
	      }
	      else System.out.println("hours should be less than "+b);
	   }
	   
	   else System.out.println("hours invalid....");
	   }
	   
	   catch(ParseException | SQLException ex){
	       ex.printStackTrace();
	   }
	     catch (Exception e) {
	    e.printStackTrace();
	   }
	    
	  }

	  void week()
	  {
	   
	   System.out.println("Enter the start date of week in format:mm-dd-yyyy");
	   String sdate=s.next();
	   System.out.println("Enter the end date of week in format:mm-dd-yyyy");
	   String edate=s.next();
	   try {
	       
	       SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
	        
	         Date date1=sdf.parse(sdate);
	         Date date2=sdf.parse(edate);
	         Date date3 = new Date();
	         date3 = sdf.parse(sdf.format(new Date()));
	         
	                 
	     if(date1.before(date2)&&date1.before(date3)&&date2.before(date3)){
	       
	 	  rs = st.executeQuery("select e.eid,sum(a.noh) as hours from emp e,att a where e.eid=a.eid and a.date>='"+sdate+"' and a.date<'"+edate+"' group by e.eid");  
	 			           while (rs.next()) 
	 			           {  
	 			               System.out.println("eid:"  
	 			                       + rs.getString("eid"));  
	 			               System.out.println("noh:"  
	 			                       + rs.getString("hours"));  
	 			              
	 			           }  
	     Calendar now = Calendar.getInstance();
	     now.add(Calendar.DATE, 1);
	     now.setTime(date1);
	     System.out.println("week of month is : " +
	                 now.get(Calendar.WEEK_OF_MONTH));
	     System.out.println("month is : " +(
	                 now.get(Calendar.MONTH)+1));
	     System.out.println("year is : " +
	                 now.get(Calendar.YEAR));
	     }
	     else System.out.println("please check the given dates.....");
	    }
	     catch (SQLException e) {
	    e.printStackTrace();
	   }
	   catch(ParseException ex){
	             ex.printStackTrace();
	         } 
	  }
	   
	  void month()
	  {
	   
	   System.out.println("Enter the start date of month in format:mm-dd-yyyy");
	   String sdate=s.next();
	   System.out.println("Enter the end date of month in format:mm-dd-yyyy");
	   String edate=s.next();
	   try {
	        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
	        
	         Date date1=sdf.parse(sdate);
	         Date date2=sdf.parse(edate);
	         Date date3 = new Date();
	         date3 = sdf.parse(sdf.format(new Date()));
	         
	                 
	     if(date1.before(date2)&&date1.before(date3)&&date2.before(date3)){
	       
	       rs = st.executeQuery("select e.eid,sum(a.noh) as hours from emp e,att a where e.eid=a.eid and a.date>='"+sdate+"' and a.date<'"+edate+"' group by e.eid");  
	 	    while (rs.next()) 
	 	    {  
	 	     System.out.println("eid:"+ rs.getString("eid"));
	              System.out.println("noh:"+ rs.getString("hours"));
	             }  
	    }
	     else System.out.println("please check the given dates.....");
	   }
	     catch (SQLException e) {
	    e.printStackTrace();
	   }
	    catch(ParseException ex){
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