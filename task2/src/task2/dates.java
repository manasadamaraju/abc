package task2;
import java.text.SimpleDateFormat;
import java.util.Date;
public class dates {
	public static void main(String[] args)

	{
		Date myDate = new Date();
	
	System.out.println(myDate);
	System.out.println(new SimpleDateFormat("MM-dd-yyyy").format(myDate));
	System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(myDate));
	System.out.println(myDate);
	}
}
