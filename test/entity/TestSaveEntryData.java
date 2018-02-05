package entity;
//��ӽ����������
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
		
		EntryData ed1 = new EntryData("E0000001","������",6.5,1);
		EntryData ed2 = new EntryData("E0000002","������",6.5,2);
		EntryData ed3 = new EntryData("E0000003","������",6.5,3);
		EntryData ed4 = new EntryData("E0000004","������",6.5,4);
		EntryData ed5 = new EntryData("E0000005","������",6.5,5);
		EntryData ed6 = new EntryData("E0000006","������",6.5,6);
		
		EntryData ed7 = new EntryData("E0000007","����",0.8,1);
		EntryData ed8 = new EntryData("E0000008","����",0.8,2);
		EntryData ed9 = new EntryData("E0000009","����",0.8,3);
		EntryData ed10 = new EntryData("E0000010","����",0.8,4);
		EntryData ed11 = new EntryData("E0000011","����",0.8,5);
		EntryData ed12 = new EntryData("E0000012","����",0.8,6);
		
		
		EntryData ed13 = new EntryData("E0000013","����",1.3,1);
		EntryData ed14 = new EntryData("E0000014","����",1.3,2);
		EntryData ed15 = new EntryData("E0000015","����",1.3,3);
		EntryData ed16 = new EntryData("E0000016","����",1.3,4);
		EntryData ed17 = new EntryData("E0000017","����",1.3,5);
		EntryData ed18 = new EntryData("E0000018","����",1.3,6);
		
		EntryData ed19 = new EntryData("E0000019","����",0.15,1);
		EntryData ed20 = new EntryData("E0000020","����",0.15,2);
		EntryData ed21 = new EntryData("E0000021","����",0.15,3);
		EntryData ed22 = new EntryData("E0000022","����",0.15,4);
		EntryData ed23 = new EntryData("E0000023","����",0.15,5);
		EntryData ed24 = new EntryData("E0000024","����",0.15,6);
		
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
