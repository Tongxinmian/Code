package just.For.you.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import just.For.you.mapping.Customer;
import just.For.you.mapping.User;
import just.For.you.*;

public class QBCSelect {
	@Test
	public void testSelect1(){
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			//查询所有
			Criteria criteria = session.createCriteria(User.class);
			List<User> list = criteria.list();
			for (User user : list) {
				System.out.println(user.getUid()+"::"+user.getUname());
			}
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}finally{
			sessionFactory.close();
		}
	}
	
	@Test
	public void testSelect2(){
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			//条件查询
			Criteria criteria = session.createCriteria(just.For.you.User.class);
//			criteria.add(Restrictions.eq("uid",3));
			criteria.add(Restrictions.like("username","%童%"));//模糊查询
			
			List<just.For.you.User> list = criteria.list();
			for (just.For.you.User user : list) {
				System.out.println(user.getUid()+"::"+user.getUsername());
			}
		} catch (Exception e) {
			tx.rollback();
		}finally{
			sessionFactory.close();
		}
	}
	
	@Test
	public void testSelect3(){
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			//分页查询
			Criteria criteria = session.createCriteria(User.class);
			criteria.setFirstResult(0);
			criteria.setMaxResults(2);
			List<User> list = criteria.list();
			for (User user : list) {
				System.out.println(user.getUid()+"::"+user.getUname());
			}
		} catch (Exception e) {
			tx.rollback();
		}finally{
			sessionFactory.close();
		}
	}
	
	@Test
	public void testSelect4(){
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			//排序查询
			Criteria criteria = session.createCriteria(User.class);
			criteria.addOrder(Order.desc("uid"));
			List<User> list = criteria.list();
			for (User user : list) {
				System.out.println(user.getUid()+"::"+user.getUname());
			}
		} catch (Exception e) {
			tx.rollback();
		}finally{
			sessionFactory.close();
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
			//统计查询
			Criteria criteria = session.createCriteria(User.class);
			criteria.setProjection(Projections.rowCount());
			Object obj = criteria.uniqueResult();
			Long lobj = (Long) obj;
			int count = lobj.intValue();
			System.out.println(count);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}finally{
			sessionFactory.close();
		}
	}
	
	
	@Test
	public void testSelect6(){
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			//离线查询
			DetachedCriteria dc = DetachedCriteria.forClass(User.class);
			Criteria criteria = dc.getExecutableCriteria(session);
			List<User> list = criteria.list();
			for (User user : list) {
				System.out.println(user.getUid()+"::"+user.getUname());
			}
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}finally{
			sessionFactory.close();
		}
	}
	
	
	
	
	
	
	
}
