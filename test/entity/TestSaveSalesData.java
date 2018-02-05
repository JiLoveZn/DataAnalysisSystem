package entity;
//添加销项测试数据
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.Test;

public class TestSaveSalesData {
	@Test
	public void testSaveSalesData(){
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
		
		SalesData sd1 = new SalesData("S0000001","鸡肉罐头",8,1);
		SalesData sd2 = new SalesData("S0000002","鸡肉罐头",0.4,2);
		SalesData sd3 = new SalesData("S0000003","鸡肉罐头",0.3,3);
		SalesData sd4 = new SalesData("S0000004","鸡肉罐头",0.3,4);
		SalesData sd5 = new SalesData("S0000005","鸡肉罐头",0.4,5);
		SalesData sd6 = new SalesData("S0000006","鸡肉罐头",0.2,6);
		
		SalesData sd7 = new SalesData("S0000007","鱼肉罐头",27,1);
		SalesData sd8 = new SalesData("S0000008","鱼肉罐头",35,2);
		SalesData sd9 = new SalesData("S0000009","鱼肉罐头",33,3);
		SalesData sd10 = new SalesData("S0000010","鱼肉罐头",30,4);
		SalesData sd11 = new SalesData("S0000011","鱼肉罐头",38,5);
		SalesData sd12 = new SalesData("S0000012","鱼肉罐头",31,6);
		
		SalesData sd13 = new SalesData("S0000013","猪肉罐头",12,1);
		SalesData sd14 = new SalesData("S0000014","猪肉罐头",10,2);
		SalesData sd15 = new SalesData("S0000015","猪肉罐头",15,3);
		SalesData sd16 = new SalesData("S0000016","猪肉罐头",17,4);
		SalesData sd17 = new SalesData("S0000017","猪肉罐头",22,5);
		SalesData sd18 = new SalesData("S0000018","猪肉罐头",19,6);
		
		session.save(sd1);
		session.save(sd2);
		session.save(sd3);
		session.save(sd4);
		session.save(sd5);
		session.save(sd6);
		session.save(sd7);
		session.save(sd8);
		session.save(sd9);
		session.save(sd10);
		session.save(sd11);
		session.save(sd12);
		session.save(sd13);
		session.save(sd14);
		session.save(sd15);
		session.save(sd16);
		session.save(sd17);
		session.save(sd18);
		
		tx.commit();
		sessionFactory.close();
	}
}
