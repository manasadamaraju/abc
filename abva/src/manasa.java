import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;


public class manasa extends HttpServlet {
public void service(ServletRequest req,ServletResponse res) throws ServletException, IOException
{
	PrintWriter out= res.getWriter();
	String uname=req.getParameter("USERNAME");
	String pword=req.getParameter("PASSWORD");
	if(uname.equalsIgnoreCase("Manasa")&& pword.equalsIgnoreCase("manu"))
	{
		out.print("Login is success");
	}
	else
	{
		out.print("Login is Fail");
	}
	out.close();
}
}
 