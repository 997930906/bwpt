package bwpt.test.Test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate框架的工具类
 * @author Administrator
 */
public class HibernateUtil {
	// 定义常量
	private static final Configuration cfg;
	private static final SessionFactory factory;
	// 静态代码块
	static{
		// 加载配置文件
		cfg = new Configuration().configure();
		// 获取到sessionFactory对象
		factory = cfg.buildSessionFactory();
	}
	
	/**
	 * 获取到session的对象
	 * @return
	 */
	public static Session openSession(){
		return factory.openSession();
	}

}
