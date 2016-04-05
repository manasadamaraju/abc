import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


public class Main {
	public static void maiN(String args[])
	{
		Resource res=new ClassPathResource("beans.xml");
		BeanFactory f=new XmlBeanFactory(res);
		Object o=f.getBean("re");
		Reporter r=(Reporter)o;
		r.showReport();
	}

}
