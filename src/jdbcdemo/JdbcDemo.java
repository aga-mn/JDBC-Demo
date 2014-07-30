package jdbcdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import jdbcdemo.dao.JdbcDaoImpl;
import jdbcdemo.dao.SimpleJdbcDaoImpl;
import jdbcdemo.model.Circle;

public class JdbcDemo {

	public static void main(String[] args) {
		
		ApplicationContext ctx=new ClassPathXmlApplicationContext("spring.xml");
		SimpleJdbcDaoImpl dao = ctx.getBean("simpleJdbcDaoImpl", SimpleJdbcDaoImpl.class);
		
		System.out.println (dao.getCricleCount());
		//System.out.println (dao.getCircleForId(1).getName());
		
		//dao.insertCircle(new Circle(5,"another circle"));
		//	dao.createTriangleTable();
		//System.out.println(dao.getAllCricles().size());
				
	}

}
