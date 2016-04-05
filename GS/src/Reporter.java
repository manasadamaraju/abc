
public class Reporter 
{
	private Generator gen;
	public void setGenerator(Generator gen)
	{
		this.gen=gen;
	}
	public void showReport()
	{
		gen.display();
	}

}
