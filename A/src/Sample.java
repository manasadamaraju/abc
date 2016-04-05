import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





public class Sample extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
//		String name=req.getParameter("t1");
		String gender=req.getParameter("t2");
		int age=Integer.parseInt(req.getParameter("t3"));
		String status;
		if(gender.equalsIgnoreCase("male"))
		{
			if(age>21)
				status="major";
			else
				status="minor";
		}
//			else if(gender.equalsIgnoreCase("female"))
//			{
//				if(age>18)
//					status="major";
//				else
//					status="minor";
//			}	
//			
		out.close();
	}

}
