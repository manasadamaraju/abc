import java.io.IOException;
import java.io.PrintWriter;


public class LoginServlet extends HttpServlet {
public void service(ServletRequest req,ServletResponse res) throws ServletException, IOException
{
	PrintWriter out= req.getWriter();
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
 