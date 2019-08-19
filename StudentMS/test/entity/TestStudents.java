package entity;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;


public class TestStudents {
	
	@Test
	public void testSchemaExport(){
		//创建配置对象
		Configuration config = new Configuration().configure();
		//创建服务注册对象
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		//创建sessionFactory
		SessionFactory sessionFaction = config.buildSessionFactory(serviceRegistry);
		//创建session对象
		Session session = sessionFaction.getCurrentSession();
		//创建SchemaExport对象
		SchemaExport export = new SchemaExport(config);
		export.create(true, true);
	}
	

	@Test
	public void testSaveStudents(){
        //创建配置对象
		Configuration config = new Configuration().configure();
		//创建服务注册对象  
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		//创建sessionFactory
		SessionFactory sessionFaction = config.buildSessionFactory(serviceRegistry);
		//创建session对象
		Session session = sessionFaction.getCurrentSession();
		//创建事务对象
		Transaction tx = session.beginTransaction();
		
		
		Students s1 = new Students("2016001", "蔡徐坤", "男", new Date(), "篮球部落");
		Students s2 = new Students("2016002", "露娜", "女", new Date(), "王者荣耀");
		Students s3 = new Students("2016003", "亚瑟", "男", new Date(), "王者荣耀");
		
		session.save(s1);
		session.save(s2);
		session.save(s3);
		
		tx.commit();
		sessionFaction.close();
	}
}
