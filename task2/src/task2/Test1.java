package task2;





import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



import java.util.Scanner;

public class Test1 {
 
 Connection con;
 Statement st;
 ResultSet rs;
 Scanner sc;
 
 
 void register()
 {
  System.out.println("Enter the Employee FIRST NAME");
  String fname=sc.next();
  System.out.println("Enter the Employee LAST NAME");
  String lname=sc.next();
  System.out.println("Enter the Employee IDNO which should be unique");
  int idno=sc.nextInt();
  
  try {
   String qry="INSERT INTO emp1(FNAME,LNAME,IDNO) VALUES('"+fname+"','"+lname+"',"+idno+")";
   int flag=st.executeUpdate(qry);
   
   if(flag!=0)
   {
    System.out.println("Registered Successfully!!!");
    rs=st.executeQuery("select IDNO from emp1 where FNAME='"+fname+"' and LNAME='"+lname+"'");
    
   }
   else{
    System.out.println("Employee already Exists!!!!");
   }
   
  } catch (SQLException e) {
   e.printStackTrace();
  }
  
 }
 void week()
 {
  
  System.out.println("Enter the start date of week in format:mm-dd-yyyy");
  String sdate=sc.next();
  System.out.println("Enter the end date of week in format:mm-dd-yyyy");
  String edate=sc.next();
  try {
      
      SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
       
        Date date1=sdf.parse(sdate);
        Date date2=sdf.parse(edate);
        Date date3 = new Date();
        date3 = sdf.parse(sdf.format(new Date()));
        
                
    if(date1.before(date2)&&date1.before(date3)&&date2.before(date3)){
      
	  rs = st.executeQuery("select e.idno,sum(w.hours) as hours from emp1 e,work w where e.idno=w.idno and w.date>='"+sdate+"' and w.date<'"+edate+"' group by e.idno");  
			           while (rs.next()) 
			           {  
			               System.out.println("idno:"  
			                       + rs.getString("idno"));  
			               System.out.println("hours:"  
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
  String sdate=sc.next();
  System.out.println("Enter the end date of month in format:mm-dd-yyyy");
  String edate=sc.next();
  try {
       SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
       
        Date date1=sdf.parse(sdate);
        Date date2=sdf.parse(edate);
        Date date3 = new Date();
        date3 = sdf.parse(sdf.format(new Date()));
        
                
    if(date1.before(date2)&&date1.before(date3)&&date2.before(date3)){
      
      rs = st.executeQuery("select e.idno,sum(w.hours) as hours from emp1 e,work w where e.idno=w.idno and w.date>='"+sdate+"' and w.date<'"+edate+"' group by e.idno");  
	    while (rs.next()) 
	    {  
	     System.out.println("idno:"+ rs.getString("idno"));
             System.out.println("hours:"+ rs.getString("hours"));
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

 void work() 
 {
  try
  {
  System.out.println("Enter the Employee ID");
  int id=sc.nextInt();
  System.out.println("Enter the PROJECT NO");
  String pno=sc.next();
  System.out.println("Enter the Working hours for project "+pno);
  int w_hrs=sc.nextInt();
  
  SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
  System.out.println("Enter the DATE in format:mm-dd-yyyy");
  String date=sc.next();
  Date date1=sdf.parse(date);
  Date date2 = new Date();
  date2 = sdf.parse(sdf.format(new Date()));
  int a=0;
  rs=st.executeQuery("select sum(hours) from work where idno="+id+" and date='"+date+"' group by"+ id+");");
  while(rs.next())
  {
	  a=rs.getInt(1);
  }
  if(a<=8)
  {
     int b=8-a;
     if(w_hrs<=b)
     {	 
	  if(date1.before(date2))
	  {	
		  int flag=st.executeUpdate("INSERT INTO work(IDNO,PNO,HOURS,DATE) VALUES("+id+",'"+pno+"',"+w_hrs+",'"+date1+"');");
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

 public static void main(String[] args) {
  // TODO Auto-generated method stub
    Test1 t1=new Test1();
    boolean flag=true;
    t1.sc=new Scanner(System.in);
    try {
        Class.forName("org.sqlite.JDBC");
        t1.con = DriverManager.getConnection("jdbc:sqlite:D:\\temp.sqlite");
        t1.st=t1.con.createStatement();
      } 
     catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      }
    
    do{
    System.out.println("Enter the option ");
    System.out.println("1.Register a employee");
    System.out.println("2.To enter work details");
    System.out.println("3.To get weekly report");
    System.out.println("4.To get monthly report");
    System.out.println("5.To Exit");
    int option=t1.sc.nextInt();
    switch(option)
    {
    case 1:t1.register();
      break;
    case 3:t1.week();
      	break;
    case 2:t1.work();
	break;	
    case 4:t1.month();
    break;
  
    case 5:flag=false;
      break;
    default:System.out.println("Invalid Input!!!");   
    }
    }
    while(flag);
 }

}