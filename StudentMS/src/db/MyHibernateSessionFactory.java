package db;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


// 会话工厂类,目的获得SessionFactory对象
public class MyHibernateSessionFactory {
	
	private static SessionFactory sessionFactory; //会话工厂属性
	// 构造函数保证单例模式
	private MyHibernateSessionFactory(){
		
	}
	//共有的静态方法，获得会话工厂对象
	public static SessionFactory getSessionFactory(){
		if(sessionFactory==null){
			//创建配置对象
			Configuration config = new Configuration().configure();
			//创建服务注册对象  
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
			//创建sessionFactory
			sessionFactory = config.buildSessionFactory(serviceRegistry);
			return sessionFactory;
		}else{
			return sessionFactory;
		}
	}
}
