package just.For.you.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import just.For.you.mapping.*;

public class HQLSelect {
	@Test
	public void testSelect1(){
		Session session = null;
		Transaction tx = null;
		try{
			session = HibernateUtils.getSessionObject();
			tx = session.beginTransaction();
			
			//条件查询
			Query query = session.createQuery("from Customer where cname like ?");
			query.setParameter(0, "童%");
			
//			Query query = session.createQuery("from Customer where cid=?");
//			query.setParameter(0, 1);
			
			List<Customer> list = query.list();
			for (Customer customer : list) {
				System.out.println(customer.getCid()+"::"+customer.getCname());
			}
			
			
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}
	}
	
	@Test
	public void testSelect2(){
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtils.getSessionObject();
			tx = session.beginTransaction();
			//排序查询
			Query query = session.createQuery("from Customer order by cid desc");
			List<Customer> list = query.list();
			for (Customer customer : list) {
				System.out.println(customer.getCid()+"::"+customer.getCname());
			}
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
	}
	
	@Test 
	public void testSelect3(){
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtils.getSessionObject();
			tx = session.beginTransaction();
			//分页查询
			Query query = session.createQuery("from User");
			query.setFirstResult(0);//开始位置
			query.setMaxResults(3);//每页记录数
			List<User> list = query.list();
			for (User user : list) {
				System.out.println(user.getUid()+"::"+user.getUname());
			}
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
	}
	
	@Test
	public void testSelect4(){
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtils.getSessionObject();
			tx = session.beginTransaction();
			
			//投影查询
			Query query = session.createQuery("select uname from User");
			List<Object> obj = query.list();
			for (Object object : obj) {
				System.out.println(object);
			}
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
	}
	
	@Test
	public void testSelect5(){
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
			//聚集函数的使用
			Query count = session.createQuery("select count(*) from User");
			Query avg = session.createQuery("select avg(uid) from User");
			Query min = session.createQuery("select min(uid) from User");
			Query max = session.createQuery("select max(uid) from User");
			Query sum = session.createQuery("select sum(uid) from User");
			//先将Object变成Long类型，再变成Int类型
			Object obj1 = count.uniqueResult();
			Long lobj1 = (Long) obj1;
			int countResult = lobj1.intValue();
			
			Object obj2 = sum.uniqueResult();
			Long lobj2 = (Long) obj2;
			int sumResult = lobj2.intValue();
			
			Object obj3 = avg.uniqueResult();
			Double avgResult = (Double) obj3;
			int minResult = (Integer) min.uniqueResult();
			int maxResult = (Integer) max.uniqueResult();
			System.out.println("count:"+countResult);
			System.out.println("avg:"+avgResult);
			System.out.println("min:"+minResult);
			System.out.println("max:"+maxResult);
			System.out.println("sum:"+sumResult);
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}finally{
			sessionFactory.close();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
