package just.For.you.hibernate;

import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import just.For.you.mapping.Customer;
import just.For.you.mapping.LinkMan;

public class HQLManyTable {
	@Test
	public void testSelect(){
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try{
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			//内连接查询
			//迫切内连接：fetch
//			Query query = session.createQuery("from Customer c inner join fetch c.lmSet");
			//左外连接
//			Query query = session.createQuery("from Customer c left outer join c.lmSet");
			//右外连接
			Query query = session.createQuery("from Customer c right outer join c.lmSet");
			List list = query.list();
			System.out.println(list.size());
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}finally{
			sessionFactory.close();
		}
	}
	@Test
	public void lazySelect(){
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try{
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			Criteria criteria = session.createCriteria(Customer.class);
			List<Customer> list = criteria.list();
			for (Customer customer : list) {
				System.out.println(customer.getCid()+":::"+customer.getCname());
				Set<LinkMan> setLinkMan = customer.getLmSet();
				for (LinkMan linkMan : setLinkMan) {
					System.out.println(linkMan.getLink_id()+"::"+linkMan.getLink_name());
				}
			}
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}finally{
			sessionFactory.close();
		}
	}
}
