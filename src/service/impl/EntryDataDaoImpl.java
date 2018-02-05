package service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import db.MyHibernateSessionFactory;
import entity.EntryData;
import service.EntryDataDao;

//���������߼��ӿڵ�ʵ����
public class EntryDataDaoImpl implements EntryDataDao {
	
	@Override
	 public int getAllRowCount(String hql){
		Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
	    Transaction tx = null;
	    int allRows = 0;
	    try{
	    	tx = session.beginTransaction();
	        Query query = session.createQuery(hql);
	        allRows = query.list().size();
	        tx.commit();       
	    }
	    catch(Exception ex){
	    	if(tx != null){
	    		ex.printStackTrace();
	    		tx.commit();
	        }
	    }
	    finally{
	    	if(tx!=null){
	    		tx = null;
			}
	    }
	    return allRows;
	 }
	@Override
	 public int getAllRowCount(String hql,int month){
		Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
	    Transaction tx = null;
	    int allRows = 0;
	    try{
	    	tx = session.beginTransaction();
	        Query query = session.createQuery(hql);
	        query.setParameter(0, month);
	        allRows = query.list().size();
	        tx.commit();       
	    }
	    catch(Exception ex){
	    	if(tx != null){
	    		ex.printStackTrace();
	    		tx.commit();
	        }
	    }
	    finally{
	    	if(tx!=null){
	    		tx = null;
			}
	    }
	    return allRows;
	}
	@Override
	 public int getAllRowCount(String hql,String item){
		Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
	    Transaction tx = null;
	    int allRows = 0;
	    try{
	    	tx = session.beginTransaction();
	        Query query = session.createQuery(hql);
	        query.setParameter(0, item);
	        allRows = query.list().size();
	        tx.commit();       
	    }
	    catch(Exception ex){
	    	if(tx != null){
	    		ex.printStackTrace();
	    		tx.commit();
	        }
	    }
	    finally{
	    	if(tx!=null){
	    		tx = null;
			}
	    }
	    return allRows;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<EntryData> queryAllEntryData(String hql, int offset, int pageSize) {
		// TODO Auto-generated method stub
		Transaction tx =null;
		List<EntryData> list = null;
		try{
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			Query query = session.createQuery(hql).setFirstResult(offset).setMaxResults(pageSize);
			list = query.list();
			tx.commit();
			return list;
		}
		catch(Exception ex){
			ex.printStackTrace();
			tx.commit();
			return list;
		}
		finally{
			if(tx!=null){
				tx = null;
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<EntryData> queryEntryDataByMonth(int month,String hql, int offset, int pageSize){
		// TODO Auto-generated method stub
		Transaction tx =null;
		List<EntryData> list = null;
		try{
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			Query query = session.createQuery(hql).setFirstResult(offset).setMaxResults(pageSize);
			query.setParameter(0, month);
			list = query.list();
			tx.commit();
			return list;
		}
		catch(Exception ex){
			ex.printStackTrace();
			tx.commit();
			return list;
		}
		finally{
			if(tx!=null){
				tx = null;
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<EntryData> queryEntryDataByItem(String item,String hql, int offset, int pageSize){
		// TODO Auto-generated method stub
		Transaction tx =null;
		List<EntryData> list = null;
		try{
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			Query query = session.createQuery(hql).setFirstResult(offset).setMaxResults(pageSize);
			query.setParameter(0, item);
			list = query.list();
			tx.commit();
			return list;
		}
		catch(Exception ex){
			ex.printStackTrace();
			tx.commit();
			return list;
		}
		finally{
			if(tx!=null){
				tx = null;
			}
		}
	}
	
	@Override
	public EntryData queryEntryDataByEid(String eid) {
		// TODO Auto-generated method stub
		Transaction tx =null;
		EntryData e = null;
		try{
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			e = (EntryData)session.get(EntryData.class, eid);
			tx.commit();
			return e;
		}
		catch(Exception ex){
			ex.printStackTrace();
			tx.commit();
			return e;
		}
		finally{
			if(tx!=null){
				tx = null;
			}
		}
	}

	@Override
	public boolean addEntryData(EntryData e) {
		// TODO Auto-generated method stub
		e.setEid(getNewEid());//���ñ��
		Transaction tx =null;
		try{
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.save(e);
			tx.commit();
			return true;
		}
		catch(Exception ex){
			ex.printStackTrace();
			tx.commit();
			return false;
		}
		finally{
			if(tx!=null){
				tx = null;
			}
		}
	}

	@Override
	public boolean updateEntryData(EntryData e) {
		// TODO Auto-generated method stub
		Transaction tx =null;
		try{
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.update(e);
			tx.commit();
			return true;
		}
		catch(Exception ex){
			ex.printStackTrace();
			tx.commit();
			return false;
		}
		finally{
			if(tx!=null){
				tx = null;
			}
		}
	}

	@Override
	public boolean deleteEntryData(String eid) {
		// TODO Auto-generated method stub
		Transaction tx =null;
		try{
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			EntryData e = (EntryData)session.get(EntryData.class, eid);
			session.delete(e);
			tx.commit();
			return true;
		}
		catch(Exception ex){
			ex.printStackTrace();
			tx.commit();
			return false;
		}
		finally{
			if(tx!=null){
				tx = null;
			}
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<EntryData> statisticsEntryData() {
		// TODO Auto-generated method stub
		Transaction tx =null;
		List<EntryData> list = null;
		String hql = "";
		try{
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			hql = "select month ,sum(money) from EntryData where month between '1' and '12' group by month";
			Query query = session.createQuery(hql);
			list = query.list();
			tx.commit();
			return list;
		}
		catch(Exception ex){
			ex.printStackTrace();
			tx.commit();
			return list;
		}
		finally{
			if(tx!=null){
				tx = null;
			}
		}
	}
	
	
	
	//���ɽ������ݱ��
	//public����JUnit���ԣ��������Ϊprivate
	public String getNewEid(){
		Transaction tx =null;
		String hql = "";
		String eid = null;
		try{
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			//��õ�ǰ�������������
			hql = "select max(eid) from EntryData";
			Query query = session.createQuery(hql);
			eid = (String)query.uniqueResult();
			if(eid==null||"".equals(eid)){
				//��һ��Ĭ�ϵ������
				eid = "E0000001";
			}
			else{
				String temp = eid.substring(1);//ȥ����ĸE
				int i = Integer.parseInt(temp);//ת������
				i++;
				//�ٻ�ԭΪ�ַ���
				temp = String.valueOf(i);
				int len = temp.length();
				//�չ�7λ
				for(int j=0;j<7-len;j++){
					temp = "0"+temp;
				}
				eid = "E"+temp;
			}
			tx.commit();
			return eid;
		}
		catch(Exception ex){
			ex.printStackTrace();
			tx.commit();
			return null;
		}
		finally{
			if(tx!=null){
				tx = null;
			}
		}
	}
	
}
