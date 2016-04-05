
public class Reporter {
	private Generator gen;
	public void setGen(Generator gen)
	{
		this.gen=gen;
	}
	public void showReport()
	{
		gen.display();
	}

}


