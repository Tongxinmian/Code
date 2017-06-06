package just.For.you.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import just.For.you.User;

public class HibernateTest {
	@Test
	public void testAdd(){
//		Step1:加载hibernate核心配置文件
//		到src下面找到名称是hibernate.cfg.xml,在hibernate里面封装对象
		Configuration cfg = new Configuration();
		cfg.configure();
//		Step2:创建SessionFactory对象
//		读取hibernate核心配置文件内容，创建SessionFactory在过程中，根据映射关系，在配置数据库中，将表创建
		SessionFactory sf = cfg.buildSessionFactory();
//		Step3:使用Sessionfactory创建session对象
		Session session = sf.openSession(); 
//		Step4:开启事务
		Transaction tx = session.beginTransaction();
//		Step5：写具体crud操作
		User user = new User();
		user.setUsername("童心眠");
		user.setPassword("123");
		user.setAddress("zhuzhou");
		session.save(user);
//		Step6:提交事务
		tx.commit();
//		Step7:关闭资源
		session.close();
		sf.close();
	}
	
	@Test
	public void testUpdate(){
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = HibernateUtils.getSessionObject();
			tx = session.beginTransaction();
			//修改
			User user = session.get(User.class,4);
			user.setUsername("童话镇");
			session.saveOrUpdate(user);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}finally{
			sessionFactory.close();
		}
	}
	
	@Test
	public void testDelete(){
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = HibernateUtils.getSessionObject();
			tx = session.beginTransaction();
			//删除
			User user = session.get(User.class,1);
			session.delete(user);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
	}
	
	@Test
	public void testQuery(){
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = HibernateUtils.getSessionObject();
			tx = session.beginTransaction();
			//Query对象
			Query query = session.createQuery("from User");
			List<User> list = query.list();
			for (User user : list) {
				System.out.println(user);
			}
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
	}
	

	@Test
	public void testCriteria(){
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = HibernateUtils.getSessionObject();
			tx = session.beginTransaction();
			//Criteria对象
			Criteria criteria  = session.createCriteria(User.class);
			List<User> list = criteria.list();
			for (User user : list) {
				System.out.println(user);
			}
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
	}
	
	@Test
	public void testSQLQuery(){
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = HibernateUtils.getSessionObject();
			tx = session.beginTransaction();
			//SQLQuery对象
			SQLQuery sql  = session.createSQLQuery("select * from t_user");
			//返回的List默认是数组结构的
			sql.addEntity(User.class);
			List<User> list = sql.list();
			for (User user : list) {
				System.out.println(user);
			}
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
	}
}
