package just.For.you.hibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import just.For.you.mapping.*;

public class HibernateManyToMany {
	@Test//级联保存
	public void testAdd1(){
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtils.getSessionObject();
			tx = session.beginTransaction();
			
			User user1 = new User();
			user1.setUname("Alice");
			user1.setPassword("123");
			User user2 = new User();
			user2.setUname("Bob");
			user2.setPassword("456");
			
			Role r1 = new Role();
			r1.setRname("教师");
			r1.setRmemo("教师");
			Role r2 = new Role();
			r2.setRname("学生");
			r2.setRmemo("学生");
			Role r3 = new Role();
			r3.setRname("校长");
			r3.setRmemo("校长");
			
			user1.getSetRole().add(r1);
			user1.getSetRole().add(r2);
			
			user2.getSetRole().add(r2);
			user2.getSetRole().add(r3);
			
			session.save(user1);
			session.save(user2);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
	}
	
	@Test//级联删除
	public void testDelete(){
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtils.getSessionObject();
			tx = session.beginTransaction();
			User user = session.get(User.class, 1);
			session.delete(user);
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
	}
	
	@Test//级联修改
	public void testUpdate(){
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtils.getSessionObject();
			tx = session.beginTransaction();
			User user = session.get(User.class, 3);
			Role role = session.get(Role.class, 6);
//			user.getSetRole().add(role);
			user.getSetRole().remove(role);
			session.update(user);
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
	}
}
