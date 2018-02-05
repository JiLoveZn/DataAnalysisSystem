package entity;
//����û���������
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
		
		Users u1 = new Users("2014352","�¼�","cjzz","��",new Date(),"18980357809",1);
		Users u2 = new Users("2014354","����","zzcj","Ů",new Date(),"15517795997",2);
		Users u3 = new Users("2014355","С��","zz","��",new Date(),"18980357809",2);
		
		session.save(u1);
		session.save(u2);
		session.save(u3);
		
		tx.commit();
		sessionFactory.close();
	}
}
