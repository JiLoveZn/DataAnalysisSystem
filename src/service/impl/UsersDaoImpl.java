package service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import db.MyHibernateSessionFactory;
import entity.Users;
import service.UsersDao;

public class UsersDaoImpl implements UsersDao {
	
	public boolean usersLogin(Users u){
		//事物对象
		Transaction tx =null;
		String hql = "";
		//int authority;
		try{
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			hql = "from Users where uid=? and password=?";
			Query query = session.createQuery(hql);
			//authority=u.getAuthority();
			query.setParameter(0, u.getUid());
			query.setParameter(1, u.getPassword());
			List list = query.list();
			tx.commit();//提交事务
			if(list.size()>0){
				return true;
			}
			else{
				return false;
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
		finally{
			if(tx!=null){
				tx = null;
			}
		}
	}
	
	
	@Override
	public List<Users> queryAllUsers() {
		// TODO Auto-generated method stub
		Transaction tx =null;
		List<Users> list = null;
		String hql = "";
		try{
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			hql = "from Users";
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

	@Override
	public Users queryUsersByUid(String uid) {
		// TODO Auto-generated method stub
		Transaction tx =null;
		Users u = null;
		try{
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			u = (Users)session.get(Users.class, uid);
			tx.commit();
			return u;
		}
		catch(Exception ex){
			ex.printStackTrace();
			tx.commit();
			return u;
		}
		finally{
			if(tx!=null){
				tx = null;
			}
		}
	}

	@Override
	public boolean addUsers(Users u) {
		// TODO Auto-generated method stub
		u.setUid(getNewUid());//设置工号
		Transaction tx =null;
		try{
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.save(u);
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
	public boolean updateUsers(Users u) {
		// TODO Auto-generated method stub
		Transaction tx =null;
		try{
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.update(u);
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
	public boolean deleteUsers(String uid) {
		// TODO Auto-generated method stub
		Transaction tx =null;
		try{
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			Users u = (Users)session.get(Users.class, uid);
			session.delete(u);
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
	
	
	//生成工号
	//public便于JUnit测试，测试完改为private
	public String getNewUid(){
		Transaction tx =null;
		String hql = "";
		String uid = null;
		try{
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			//获得当前用户的最大工号
			hql = "select max(uid) from Users";
			Query query = session.createQuery(hql);
			uid = (String)query.uniqueResult();
			if(uid==null||"".equals(uid)){
				//给一个默认的最大工号
				uid = "2014011001";
			}
			else{
				int i = Integer.parseInt(uid);//转成数字
				i++;
				//再还原为字符串
				String temp = String.valueOf(i);
				int len = temp.length();
				//凑够10位
				for(int j=0;j<7-len;j++){
					temp = "0"+temp;
				}
				uid = temp;
			}
			tx.commit();
			return uid;
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
