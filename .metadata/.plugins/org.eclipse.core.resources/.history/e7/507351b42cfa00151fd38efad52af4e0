import org.springframework.core.io.Resource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
public class Main {
	public static void main(String args[])
	{
		Resource r=new ClassPathResource("spring-config.xml");
		BeanFactory f=new XmlBeanFactory(r);
		Object o=f.getBean("db");
		DemoBean d=(DemoBean)o;
		d.getMsg();		
	}
	

}
