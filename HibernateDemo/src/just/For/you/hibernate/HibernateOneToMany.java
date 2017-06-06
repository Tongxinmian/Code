package just.For.you.hibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import just.For.you.mapping.*;

public class HibernateOneToMany {
	@Test//级联保存
	public void testAdd1(){
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = HibernateUtils.getSessionObject();
			tx = session.beginTransaction();
			Customer customer = new Customer();
			customer.setCname("童话镇");
			customer.setClevel("VIP");
			customer.setCphone("123456");
			LinkMan linkMan = new LinkMan();
			linkMan.setLink_name("Alice");
			linkMan.setLink_gender("女");
			linkMan.setLink_phone("654312");
			
			customer.getLmSet().add(linkMan);
			linkMan.setCustomer(customer);
			session.save(customer);
			session.save(linkMan);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
	}
	@Test//级联保存
	public void testAdd2(){
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = HibernateUtils.getSessionObject();
			tx = session.beginTransaction();
			Customer customer = new Customer();
			customer.setCname("童心眠");
			customer.setClevel("VIP");
			customer.setCphone("123456");
			LinkMan linkMan = new LinkMan();
			linkMan.setLink_name("Tongx");
			linkMan.setLink_gender("男");
			linkMan.setLink_phone("654312");
			
			customer.getLmSet().add(linkMan);
			session.save(customer);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
	}
	
	@Test//级联删除
	public void testDelete(){
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = HibernateUtils.getSessionObject();
			tx = session.beginTransaction();
			Customer customer = session.get(Customer.class, 2);
			session.delete(customer);
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
	}
	
	@Test//级联修改
	public void testUpdate(){
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = HibernateUtils.getSessionObject();
			tx = session.beginTransaction();
			Customer customer = session.get(Customer.class, 3);
			LinkMan linkMan = session.get(LinkMan.class, 1);
			customer.getLmSet().add(linkMan);
			linkMan.setCustomer(customer);
			session.update(customer);
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
	}
}
