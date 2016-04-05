
public class Employee {
	private int id;
	private String name;
	private Address addr;
	public Employee()
	{
		System.out.println("default constructor");

	}
	public Employee(int id,String name,Address addr)
	{
		//super();
		this.id=id;
		this.name=name;
		this.addr=addr;
	}
	void show()
	{
		System.out.println(id+" "+name);
		System.out.println(addr.toString());
	}

}
