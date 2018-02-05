package entity;
//添加用户测试数据
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.Test;

public class TestSaveUsers {
	@Test
	public void testSaveUsers(){
		//创建配置对象
		Configuration config = new Configuration().configure();
		//创建服务注册对象
		ServiceRegistry serviceRegisty = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		//创建sessionFactory
		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegisty);
		//获得一个session对象 
		Session session = sessionFactory.getCurrentSession();
		//创建事物对象
		Transaction tx = session.beginTransaction();
		
		Users u1 = new Users("2014352","陈吉","cjzz","男",new Date(),"18980357809",1);
		Users u2 = new Users("2014354","赵珍","zzcj","女",new Date(),"15517795997",2);
		Users u3 = new Users("2014355","小明","zz","男",new Date(),"18980357809",2);
		
		session.save(u1);
		session.save(u2);
		session.save(u3);
		
		tx.commit();
		sessionFactory.close();
	}
}
