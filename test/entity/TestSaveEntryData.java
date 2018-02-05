package entity;
//添加进项测试数据
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.Test;

public class TestSaveEntryData {
	@Test
	public void testSaveEntryData(){
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
		
		EntryData ed1 = new EntryData("E0000001","花生油",6.5,1);
		EntryData ed2 = new EntryData("E0000002","花生油",6.5,2);
		EntryData ed3 = new EntryData("E0000003","花生油",6.5,3);
		EntryData ed4 = new EntryData("E0000004","花生油",6.5,4);
		EntryData ed5 = new EntryData("E0000005","花生油",6.5,5);
		EntryData ed6 = new EntryData("E0000006","花生油",6.5,6);
		
		EntryData ed7 = new EntryData("E0000007","鸡肉",0.8,1);
		EntryData ed8 = new EntryData("E0000008","鸡肉",0.8,2);
		EntryData ed9 = new EntryData("E0000009","鸡肉",0.8,3);
		EntryData ed10 = new EntryData("E0000010","鸡肉",0.8,4);
		EntryData ed11 = new EntryData("E0000011","鸡肉",0.8,5);
		EntryData ed12 = new EntryData("E0000012","鸡肉",0.8,6);
		
		
		EntryData ed13 = new EntryData("E0000013","鱼肉",1.3,1);
		EntryData ed14 = new EntryData("E0000014","鱼肉",1.3,2);
		EntryData ed15 = new EntryData("E0000015","鱼肉",1.3,3);
		EntryData ed16 = new EntryData("E0000016","鱼肉",1.3,4);
		EntryData ed17 = new EntryData("E0000017","鱼肉",1.3,5);
		EntryData ed18 = new EntryData("E0000018","鱼肉",1.3,6);
		
		EntryData ed19 = new EntryData("E0000019","玻璃",0.15,1);
		EntryData ed20 = new EntryData("E0000020","玻璃",0.15,2);
		EntryData ed21 = new EntryData("E0000021","玻璃",0.15,3);
		EntryData ed22 = new EntryData("E0000022","玻璃",0.15,4);
		EntryData ed23 = new EntryData("E0000023","玻璃",0.15,5);
		EntryData ed24 = new EntryData("E0000024","玻璃",0.15,6);
		
		session.save(ed1);
		session.save(ed2);
		session.save(ed3);
		session.save(ed4);
		session.save(ed5);
		session.save(ed6);
		session.save(ed7);
		session.save(ed8);
		session.save(ed9);
		session.save(ed10);
		session.save(ed11);
		session.save(ed12);
		session.save(ed13);
		session.save(ed14);
		session.save(ed15);
		session.save(ed16);
		session.save(ed17);
		session.save(ed18);
		session.save(ed19);
		session.save(ed20);
		session.save(ed21);
		session.save(ed22);
		session.save(ed23);
		session.save(ed24);
		
		tx.commit();
		sessionFactory.close();
	}
}
