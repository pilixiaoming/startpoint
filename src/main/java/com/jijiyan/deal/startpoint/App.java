package com.jijiyan.deal.startpoint;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jijiyan.deal.startpoint.model.User;

/**
 * Hello world!
 *
 */
public class App 
{
	
    public static void main( String[] args )
    {
    	App app = new App();
        System.out.println(app.getClass().getResource("") );

        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:/spring/context.xml");
        User user = (User)ac.getBean("user");
        System.out.println(user.getName());
    }
}
