package com.tutorialspoint;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class MainApp {
	public static void main(String args[])
	{
		ApplicationContext= new ClassPathXmlApplicationContext("Beans.xml");
		HelloWorld h= (HelloWorld) context.getBean("helloWorld");
		h.getMessage();
	}

}
