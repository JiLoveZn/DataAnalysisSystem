package entity;
//��������������
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
		//�������ö���
		Configuration config = new Configuration().configure();
		//��������ע�����
		ServiceRegistry serviceRegisty = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		//����sessionFactory
		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegisty);
		//���һ��session���� 
		Session session = sessionFactory.getCurrentSession();
		//�����������
		Transaction tx = session.beginTransaction();
		
		SalesData sd1 = new SalesData("S0000001","�����ͷ",8,1);
		SalesData sd2 = new SalesData("S0000002","�����ͷ",0.4,2);
		SalesData sd3 = new SalesData("S0000003","�����ͷ",0.3,3);
		SalesData sd4 = new SalesData("S0000004","�����ͷ",0.3,4);
		SalesData sd5 = new SalesData("S0000005","�����ͷ",0.4,5);
		SalesData sd6 = new SalesData("S0000006","�����ͷ",0.2,6);
		
		SalesData sd7 = new SalesData("S0000007","�����ͷ",27,1);
		SalesData sd8 = new SalesData("S0000008","�����ͷ",35,2);
		SalesData sd9 = new SalesData("S0000009","�����ͷ",33,3);
		SalesData sd10 = new SalesData("S0000010","�����ͷ",30,4);
		SalesData sd11 = new SalesData("S0000011","�����ͷ",38,5);
		SalesData sd12 = new SalesData("S0000012","�����ͷ",31,6);
		
		SalesData sd13 = new SalesData("S0000013","�����ͷ",12,1);
		SalesData sd14 = new SalesData("S0000014","�����ͷ",10,2);
		SalesData sd15 = new SalesData("S0000015","�����ͷ",15,3);
		SalesData sd16 = new SalesData("S0000016","�����ͷ",17,4);
		SalesData sd17 = new SalesData("S0000017","�����ͷ",22,5);
		SalesData sd18 = new SalesData("S0000018","�����ͷ",19,6);
		
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
