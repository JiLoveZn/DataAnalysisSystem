package service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import db.MyHibernateSessionFactory;
import entity.SalesData;
import service.SalesDataDao;

//��������ҵ���߼��ӿڵ�ʵ����
public class SalesDataDaoImpl implements SalesDataDao {
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
	public List<SalesData> queryAllSalesData(String hql, int offset, int pageSize) {
		// TODO Auto-generated method stub
		Transaction tx =null;
		List<SalesData> list = null;
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
	public List<SalesData> querySalesDataByMonth(int month,String hql, int offset, int pageSize){
		// TODO Auto-generated method stub
		Transaction tx =null;
		List<SalesData> list = null;
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
	public List<SalesData> querySalesDataByItem(String item,String hql, int offset, int pageSize){
		// TODO Auto-generated method stub
		Transaction tx =null;
		List<SalesData> list = null;
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
	public SalesData querySalesDataBySid(String sid) {
		// TODO Auto-generated method stub
		Transaction tx =null;
		SalesData s = null;
		try{
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			s = (SalesData)session.get(SalesData.class, sid);
			tx.commit();
			return s;
		}
		catch(Exception ex){
			ex.printStackTrace();
			tx.commit();
			return s;
		}
		finally{
			if(tx!=null){
				tx = null;
			}
		}
	}

	@Override
	public boolean addSalesData(SalesData s) {
		// TODO Auto-generated method stub
		s.setSid(getNewSid());//���ñ��
		Transaction tx =null;
		try{
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.save(s);
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
	public boolean updateSalesData(SalesData s) {
		// TODO Auto-generated method stub
		Transaction tx =null;
		try{
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.update(s);
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
	public boolean deleteSalesData(String sid) {
		// TODO Auto-generated method stub
		Transaction tx =null;
		try{
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			SalesData s = (SalesData)session.get(SalesData.class, sid);
			session.delete(s);
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
	public List<Integer> countSalesData() {
		// TODO Auto-generated method stub
		Transaction tx =null;
		List<Integer> list = null;
		String hql = "";
		try{
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			hql = "select s.month,sum(s.money) from SalesData s where s.month between '1' and '6' group by s.month";
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
	@SuppressWarnings("unchecked")
	@Override
	public List<SalesData> statisticsSalesData(){
		// TODO Auto-generated method stub
		Transaction tx =null;
		List<SalesData> list = null;
		String hql = "";
		try{
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			hql = "select month ,sum(money) from SalesData where month between '1' and '12' group by month";
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
	
	
	//�����������ݱ��
	//public����JUnit���ԣ��������Ϊprivate
	public String getNewSid(){
		Transaction tx =null;
		String hql = "";
		String sid = null;
		try{
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			//��õ�ǰѧ���������
			hql = "select max(sid) from SalesData";
			Query query = session.createQuery(hql);
			sid = (String)query.uniqueResult();
			if(sid==null||"".equals(sid)){
				//��һ��Ĭ�ϵ������
				sid = "S0000001";
			}
			else{
				String temp = sid.substring(1);//ȥ����ĸS
				int i = Integer.parseInt(temp);//ת������
				i++;
				//�ٻ�ԭΪ�ַ���
				temp = String.valueOf(i);
				int len = temp.length();
				//�չ�7λ
				for(int j=0;j<7-len;j++){
					temp = "0"+temp;
				}
				sid = "S"+temp;
			}
			tx.commit();
			return sid;
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
