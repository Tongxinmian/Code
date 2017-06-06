package just.For.you.hibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static SessionFactory sessionFactory = null;
	static {
		Configuration config = new Configuration().configure();
		sessionFactory = config.buildSessionFactory();
	}
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	public static Session getSessionObject(){
		return sessionFactory.getCurrentSession();
	}
	public static void main(String[] args){
		
	}
}
