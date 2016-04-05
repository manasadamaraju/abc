import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;



public class Main {
	public static void main(String args[])
	{
		Resource r=new ClassPathResource("abc.xml");
		BeanFactory f=new XmlBeanFactory(r);
		Employee e=(Employee)f.getBean("b");
		e.show();
	}

}
