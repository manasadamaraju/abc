

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


public class Main {
	public static void main(String[] args) 
	{
		Resource res=new ClassPathResource("beans.xml");
		BeanFactory f=new XmlBeanFactory(res);
		Object o=f.getBean("r2");
		Reporter r=(Reporter)o;
		r.showReport();

	}

}
