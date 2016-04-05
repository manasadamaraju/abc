import java.util.Iterator;
import java.util.List;

public class Ques {
	private int id;
	private String name;
	private List<String> ans;
	public void displayInfo()
	{
		System.out.println(id+" "+name);
		System.out.println("answers are");
		Iterator<String> itr=ans.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
	}

}
