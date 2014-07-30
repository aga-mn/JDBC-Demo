package jdbcdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import jdbcdemo.dao.JdbcDaoImpl;
import jdbcdemo.model.Circle;

public class JdbcDemo {

	public static void main(String[] args) {
		
		ApplicationContext ctx=new ClassPathXmlApplicationContext("spring.xml");
		JdbcDaoImpl dao = ctx.getBean("jdbcDaoImpl", JdbcDaoImpl.class);
		
		//System.out.println (dao.getCircleCount());
		//System.out.println (dao.getCircleForId(1).getName());
		
		//dao.insertCircle(new Circle(3,"third circle"));
		dao.createTriangleTable();
		System.out.println(dao.getAllCricles().size());
		
	}

}
